var DBZ;
(function (DBZ) {
    (function (ShisetSunyushoInfo) {
        var Events = (function () {
            function Events() {
            }
            return Events;
        })();
        ShisetSunyushoInfo.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetSunyushoInfo";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetSunyushoInfo.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetSunyushoInfo.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetSunyushoInfo = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.txtNyushoShisetsuCode = function () {
                return new UZA.TextBoxCode(this.convFiledName("txtNyushoShisetsuCode"));
            };

            Controls.prototype.txtNyushoShisetsuName = function () {
                return new UZA.TextBox(this.convFiledName("txtNyushoShisetsuName"));
            };

            Controls.prototype.txtShisetsunyuShoDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsunyuShoDay"));
            };

            Controls.prototype.txtShisetsuTaishoDay = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtShisetsuTaishoDay"));
            };
            return Controls;
        })();
        ShisetSunyushoInfo.Controls = Controls;
    })(DBZ.ShisetSunyushoInfo || (DBZ.ShisetSunyushoInfo = {}));
    var ShisetSunyushoInfo = DBZ.ShisetSunyushoInfo;
})(DBZ || (DBZ = {}));
