var DBZ;
(function (DBZ) {
    (function (ChosahyoTokkiImages) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ChosahyoTokkiImages.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ChosahyoTokkiImages";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ChosahyoTokkiImages.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ChosahyoTokkiImages.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ChosahyoTokkiImages = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.ddlTokkiJikoNos = function () {
                return new UZA.DropDownList(this.convFiledName("ddlTokkiJikoNos"));
            };

            Controls.prototype.btnToDisplay = function () {
                return new UZA.Button(this.convFiledName("btnToDisplay"));
            };
            return Controls;
        })();
        ChosahyoTokkiImages.Controls = Controls;
    })(DBZ.ChosahyoTokkiImages || (DBZ.ChosahyoTokkiImages = {}));
    var ChosahyoTokkiImages = DBZ.ChosahyoTokkiImages;
})(DBZ || (DBZ = {}));
