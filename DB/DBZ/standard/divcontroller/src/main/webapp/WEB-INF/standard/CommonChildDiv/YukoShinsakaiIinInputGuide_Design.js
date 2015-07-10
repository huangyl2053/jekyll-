var DBE;
(function (DBE) {
    (function (YukoShinsakaiIinInputGuide) {
        var Events = (function () {
            function Events() {
            }
            Events.onSelectBySelectButton_dgYukoShinsakaiIin = function () {
                return "onSelectBySelectButton_dgYukoShinsakaiIin";
            };

            Events.onClick_btnClose = function () {
                return "onClick_btnClose";
            };
            return Events;
        })();
        YukoShinsakaiIinInputGuide.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YukoShinsakaiIinInputGuide";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBE.YukoShinsakaiIinInputGuide.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBE.YukoShinsakaiIinInputGuide.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YukoShinsakaiIinInputGuide = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.dgYukoShinsakaiIin = function () {
                return new UZA.DataGrid(this.convFiledName("dgYukoShinsakaiIin"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        YukoShinsakaiIinInputGuide.Controls = Controls;
    })(DBE.YukoShinsakaiIinInputGuide || (DBE.YukoShinsakaiIinInputGuide = {}));
    var YukoShinsakaiIinInputGuide = DBE.YukoShinsakaiIinInputGuide;
})(DBE || (DBE = {}));
