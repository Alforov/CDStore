var array;
var page;
$(document)
		.ready(
				function() {

					$("#type")
							.load("http://localhost:8080/CDStore/search/type");

					$("#type")
							.change(
									function() {
										var url = "http://localhost:8080/CDStore/search/genre/"
												+ $('#type').val();
										$("#genre").load(url);
									});
					
					$('#search').keypress(function(event) {
						if (event.which == '13') {
							event.preventDefault();

							search();
							$('#search').val("");
						}
					});
					$('#search')
							.keyup(
									function(e) {
										searchbox();										
									});

					$('#first').click(function() {
						var ins_block = document.getElementById("innertable");
						var htm = $("#innertable").html();
						array[page] = htm;
						page = 0;
						ins_block.innerHTML = array[page];

					});

					$('#next').click(function() {
						var ins_block = document.getElementById("innertable");
						var htm = $("#innertable").html();
						array[page] = htm;
						if (page < array.length - 1) {
							page++;

						}
						ins_block.innerHTML = array[page];

					});
					$('#prev').click(function() {
						var ins_block = document.getElementById("innertable");
						var htm = $("#innertable").html();
						array[page] = htm;
						if (page > 0) {
							page--;

						}
						ins_block.innerHTML = array[page];

					});

					$('#last').click(function() {
						var ins_block = document.getElementById("innertable");
						var htm = $("#innertable").html();
						array[page] = htm;
						page = array.length - 1;
						ins_block.innerHTML = array[page];

					});

					$('#go').click(function() {

						search();

					});
					
					$('#add')
					.click(
							function() {
								var url = "http://localhost:8080/CDStore/admin/save/"
										+ $('#search').val()
										+ "/"
										+ $('#type').val()
										+ "/"
										+ $('#genre').val();
								$.post(url, function(data) {
									$("#deleteresult").html(data);
								});
							});
					$('#delete')
							.click(
									function() {

										alert("delete");
										var cheks = document
												.getElementsByClassName('checkclass');
										var filter = "";
										for (i = 0; i < cheks.length; i++) {
											if (cheks[i].checked) {

												filter += cheks[i].value
														+ "split";
											}
										}
										if (filter == "") {
											filter = "0";
										}

										var url = "http://localhost:8080/CDStore/admin/delete/"
												+ filter;
										$
												.post(
														url,
														function(data) {
															$("#deleteresult")
																	.html(
																			"<h4>"
																					+ data
																					+ "</h4><h1>Ok</h1>");
														});

									});

					$('#basket').click(
							function() {

								var cheks = document
										.getElementsByClassName('checkclass');
								var filter = "";
								for (i = 0; i < cheks.length; i++) {
									if (cheks[i].checked) {

										filter += cheks[i].value + "split";
									}
								}
								if (filter == "") {
									filter = "0";
								}

								var url = "http://localhost:8080/CDStore/cart/"
										+ filter;
								$.post(url, function(data) {
									$("#ok").html("<h4>" + data + "</h4>");
								});

							});

					$("#paginator button")
							.click(
									function() {

										document.getElementById("pagepag").innerHTML = (page + 1)
												+ " FROM "
												+ array.length
												+ " PAGES";
									});
					$('#oder')
					.click(
							function() {
								alert("ok");
							});
				});
function fill(Value) {
	$('#search').val(Value);
	$('#display').hide();
};

function plus(Value, Target, p) {
	var amount = parseInt(document.getElementById(Value).value);
	var price = parseFloat(p);
	var delta = amount + 1;
	document.getElementById(Value).value = delta;

	document.getElementById(Target).innerHTML = (delta * price).toFixed(2);
	summa();

};
function minus(Value, Target, p) {
	var amount = parseInt(document.getElementById(Value).value);
	if (amount != 1) {

		var price = parseFloat(p);
		var delta = amount - 1;
		document.getElementById(Value).value = delta;
		document.getElementById(Target).innerHTML = (delta * price).toFixed(2);
		summa();
	}
};
function summa() {

	var element = document.getElementsByClassName('amount');
	var total = 0;

	for (i = 0; i < element.length; i++) {
		total += parseFloat(element[i].innerHTML);
	}

	document.getElementById("total").innerHTML = total.toFixed(2);

}

function searchbox(){
	var filter = $('#search').val();											
	filter = filter.split(' ').join('%20');										
		var url = "http://localhost:8080/CDStore/search/"
				+ filter
				+ "/"
				+ $('#type').val()
				+ "/"
				+ $('#genre').val();
		if (filter.length > 0) {
			$('#display').show();

			$("#display").load(url);
		} else {
			$('#display').hide();
		}
}

function search() {

	var filter = $('#search').val();
	if (filter == '') {
		filter = '||';
	}
	
	var url = "http://localhost:8080/CDStore/search/result/" + filter + "/"
			+ $('#type').val() + "/" + $('#genre').val();

	$
			.get(
					url,
					function(data) {

						var numberonpage = 13;
						var spliter = data.split("||");
						var json = jQuery.parseJSON(spliter[0]);
						var index = spliter[1];
						var pages = Math.ceil(index / numberonpage);
						array = [ pages ];

						var table = "<table><thead><tr><th>Order</th><th>Type</th><th>Genre</th><th>Film name</th></tr></thead><tbody>";
						var count = 0;
						var incrementor = 0;
						var arrayindex = 0;
						$
								.each(
										json.films,
										function(key, value) {

											incrementor++;

											if (count == 0) {
												array[arrayindex] = "<table><thead><tr><th>Order</th><th>Type</th><th>Genre</th><th>Film name</th></tr></thead><tbody>";
											}
											array[arrayindex] += "<tr class=\"rowtd\"><td class=\"odertd\"> <input type=\"checkbox\" class=\"checkclass\" value=\""
													+ value.oder
													+ "\" /> </td class=\"typetd\"><td>"
													+ value.type
													+ "</td><td class=\"genretd\">"
													+ value.genre
													+ "</td><td class=\"nametd\">"
													+ value.name + "</td></tr>"
											count++;

											if ((count == numberonpage)
													|| (incrementor == index)) {
												array[arrayindex] += "</tbody></table>";
												arrayindex++;
												count = 0;
											}

										});

						var ins_block = document.getElementById("innertable");
						page = 0;
						ins_block.innerHTML = array[page];

						document.getElementById("pagepag").innerHTML = (page + 1)
								+ " FROM " + array.length + " PAGES";

					});

}