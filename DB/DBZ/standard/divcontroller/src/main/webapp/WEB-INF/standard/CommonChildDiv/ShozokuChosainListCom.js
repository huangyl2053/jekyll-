var DBE;
(function (DBE) {
    (function (ShozokuChosainListCom) {
        var ModeController = (function () {
            function ModeController(fieldName) {
                this.fieldName = fieldName;
                this.controls = new ShozokuChosainListCom.Controls(fieldName);
            }
            ModeController.prototype.Properties = function () {
                return new UZA.CommonChildDiv(this.fieldName);
            };
            return ModeController;
        })();
        ShozokuChosainListCom.ModeController = ModeController;
    })(DBE.ShozokuChosainListCom || (DBE.ShozokuChosainListCom = {}));
    var ShozokuChosainListCom = DBE.ShozokuChosainListCom;
})(DBE || (DBE = {}));

var DBE;
(function (DBE) {
    (function (ShozokuChosainListCom) {
        var PublicProperties = (function () {
            function PublicProperties(fieldName) {
                this.controls = new ShozokuChosainListCom.Controls(fieldName);
            }
            PublicProperties.prototype.getEditTypes = function () {
                var editTypes = new UZA.EditTypeForPublicProperty();

                editTypes.addEditType("height", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSort", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelect", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onSelectByDblClick", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onOnlyRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onNoRow", UZA.EditTypeEnumForPublicProperty.StringType);
                editTypes.addEditType("onMultiRows", UZA.EditTypeEnumForPublicProperty.StringType);
                return editTypes;
            };

            PublicProperties.prototype.getheight = function () {
                return this.controls.dgShozokuChosainList().height;
            };

            PublicProperties.prototype.setheight = function (value) {
                this.controls.dgShozokuChosainList().height = value;
            };

            PublicProperties.prototype.getonSort = function () {
                return this.controls.dgShozokuChosainList().onSort;
            };

            PublicProperties.prototype.setonSort = function (value) {
                this.controls.dgShozokuChosainList().onSort = value;
            };

            PublicProperties.prototype.getonSelect = function () {
                return this.controls.dgShozokuChosainList().onSelect;
            };

            PublicProperties.prototype.setonSelect = function (value) {
                this.controls.dgShozokuChosainList().onSelect = value;
            };

            PublicProperties.prototype.getonSelectByDblClick = function () {
                return this.controls.dgShozokuChosainList().onSelectByDblClick;
            };

            PublicProperties.prototype.setonSelectByDblClick = function (value) {
                this.controls.dgShozokuChosainList().onSelectByDblClick = value;
            };

            PublicProperties.prototype.getonOnlyRow = function () {
                return this.controls.dgShozokuChosainList().onOnlyRow;
            };

            PublicProperties.prototype.setonOnlyRow = function (value) {
                this.controls.dgShozokuChosainList().onOnlyRow = value;
            };

            PublicProperties.prototype.getonNoRow = function () {
                return this.controls.dgShozokuChosainList().onNoRow;
            };

            PublicProperties.prototype.setonNoRow = function (value) {
                this.controls.dgShozokuChosainList().onNoRow = value;
            };

            PublicProperties.prototype.getonMultiRows = function () {
                return this.controls.dgShozokuChosainList().onMultiRows;
            };

            PublicProperties.prototype.setonMultiRows = function (value) {
                this.controls.dgShozokuChosainList().onMultiRows = value;
            };
            return PublicProperties;
        })();
        ShozokuChosainListCom.PublicProperties = PublicProperties;
    })(DBE.ShozokuChosainListCom || (DBE.ShozokuChosainListCom = {}));
    var ShozokuChosainListCom = DBE.ShozokuChosainListCom;
})(DBE || (DBE = {}));
