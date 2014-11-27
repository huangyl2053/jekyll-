var DBZ;
(function (DBZ) {
    (function (SearchResultOfHihokensha) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        SearchResultOfHihokensha.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "SearchResultOfHihokensha";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.SearchResultOfHihokensha.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.SearchResultOfHihokensha.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.SearchResultOfHihokensha = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgSearchResult = function () {
                return new UZA.DataGrid(this.convFiledName("dgSearchResult"));
            };

            Controls.prototype.ButtonsForSearchResultOfHihokensha = function () {
                return new UZA.Panel(this.convFiledName("ButtonsForSearchResultOfHihokensha"));
            };

            Controls.prototype.btnToResearch = function () {
                return new UZA.Button(this.convFiledName("btnToResearch"));
            };
            return Controls;
        })();
        SearchResultOfHihokensha.Controls = Controls;
    })(DBZ.SearchResultOfHihokensha || (DBZ.SearchResultOfHihokensha = {}));
    var SearchResultOfHihokensha = DBZ.SearchResultOfHihokensha;
})(DBZ || (DBZ = {}));
