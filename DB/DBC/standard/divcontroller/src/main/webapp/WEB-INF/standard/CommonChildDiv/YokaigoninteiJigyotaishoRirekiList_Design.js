var DBC;
(function (DBC) {
    (function (YokaigoninteiJigyotaishoRirekiList) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_BtnClose = function () {
                return "onClick_BtnClose";
            };
            return Events;
        })();
        YokaigoninteiJigyotaishoRirekiList.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "YokaigoninteiJigyotaishoRirekiList";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBC.YokaigoninteiJigyotaishoRirekiList.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBC.YokaigoninteiJigyotaishoRirekiList.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.YokaigoninteiJigyotaishoRirekiList = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.pnlYokaigoNintei = function () {
                return new UZA.Panel(this.convFiledName("pnlYokaigoNintei"));
            };

            Controls.prototype.dgNinteiRirekiList = function () {
                return new UZA.DataGrid(this.convFiledName("dgNinteiRirekiList"));
            };

            Controls.prototype.pnlJigyoTaishosha = function () {
                return new UZA.Panel(this.convFiledName("pnlJigyoTaishosha"));
            };

            Controls.prototype.dgJigyoTaishoshaList = function () {
                return new UZA.DataGrid(this.convFiledName("dgJigyoTaishoshaList"));
            };

            Controls.prototype.pnlBottonArea = function () {
                return new UZA.Panel(this.convFiledName("pnlBottonArea"));
            };

            Controls.prototype.btnClose = function () {
                return new UZA.Button(this.convFiledName("btnClose"));
            };
            return Controls;
        })();
        YokaigoninteiJigyotaishoRirekiList.Controls = Controls;
    })(DBC.YokaigoninteiJigyotaishoRirekiList || (DBC.YokaigoninteiJigyotaishoRirekiList = {}));
    var YokaigoninteiJigyotaishoRirekiList = DBC.YokaigoninteiJigyotaishoRirekiList;
})(DBC || (DBC = {}));
