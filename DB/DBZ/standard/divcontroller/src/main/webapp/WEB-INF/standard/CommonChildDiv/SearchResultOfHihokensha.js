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
