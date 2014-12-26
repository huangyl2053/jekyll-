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
var DBZ;
(function (DBZ) {
    (function (SearchResultOfHihokensha) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new SearchResultOfHihokensha.Controls(fieldName);
            }
            ModeController.prototype.priorities = function () {
                return [];
            };

            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };

            ModeController.prototype.PublicProperties = function () {
                return new SearchResultOfHihokensha.PublicProperties(this.fieldName);
            };
            return ModeController;
        })();
        SearchResultOfHihokensha.ModeController = ModeController;
    })(DBZ.SearchResultOfHihokensha || (DBZ.SearchResultOfHihokensha = {}));
    var SearchResultOfHihokensha = DBZ.SearchResultOfHihokensha;
})(DBZ || (DBZ = {}));

var DBZ;
(function (DBZ) {
    (function (SearchResultOfHihokensha) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new SearchResultOfHihokensha.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("onClick_btnToResearch", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("height_dgSearchResult", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getonClick_btnToResearch = function () {
                return this.controls.btnToResearch().onClick;
            };

            PublicProperties.prototype.setonClick_btnToResearch = function (value) {
                this.controls.btnToResearch().onClick = value;
            };

            PublicProperties.prototype.getheight_dgSearchResult = function () {
                return this.controls.dgSearchResult().height;
            };

            PublicProperties.prototype.setheight_dgSearchResult = function (value) {
                this.controls.dgSearchResult().height = value;
            };
            return PublicProperties;
        })();
        SearchResultOfHihokensha.PublicProperties = PublicProperties;
    })(DBZ.SearchResultOfHihokensha || (DBZ.SearchResultOfHihokensha = {}));
    var SearchResultOfHihokensha = DBZ.SearchResultOfHihokensha;
})(DBZ || (DBZ = {}));
