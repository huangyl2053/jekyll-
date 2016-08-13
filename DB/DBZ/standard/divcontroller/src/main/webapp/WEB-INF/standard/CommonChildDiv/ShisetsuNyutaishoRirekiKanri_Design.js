var DBZ;
(function (DBZ) {
    (function (ShisetsuNyutaishoRirekiKanri) {
        var Events = (function () {
            function Events() {
            }
            Events.onClick_btnAddShisetsuNyutaisho = function () {
                return "onClick_btnAddShisetsuNyutaisho";
            };

            Events.onSelectBySelectButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectBySelectButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByModifyButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByModifyButton_dgShisetsuNyutaishoRireki";
            };

            Events.onSelectByDeleteButton_dgShisetsuNyutaishoRireki = function () {
                return "onSelectByDeleteButton_dgShisetsuNyutaishoRireki";
            };

            Events.onBlur_nyuryokuHokensyaCode = function () {
                return "onBlur_nyuryokuHokensyaCode";
            };

            Events.onClick_BtnHokenshaInputGuide = function () {
                return "onClick_BtnHokenshaInputGuide";
            };

            Events.onClick_btnShisetsuNyutaishoKakutei = function () {
                return "onClick_btnShisetsuNyutaishoKakutei";
            };

            Events.onClick_btnShisetsuNyutaishoTorikeshi = function () {
                return "onClick_btnShisetsuNyutaishoTorikeshi";
            };
            return Events;
        })();
        ShisetsuNyutaishoRirekiKanri.Events = Events;

        var Controls = (function () {
            function Controls(fieldName) {
                this._myName = fieldName;
            }
            Controls.myType = function () {
                return "ShisetsuNyutaishoRirekiKanri";
            };

            Controls.prototype.convFiledNameSelf = function () {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType();
            };

            Controls.prototype.convFiledName = function (fieldName) {
                return this._myName + "_" + DBZ.ShisetsuNyutaishoRirekiKanri.Controls.myType() + "_" + fieldName;
            };

            Controls.prototype.ShisetsuNyutaishoRirekiKanri = function () {
                return new UZA.Panel(this.convFiledNameSelf());
            };

            Controls.prototype.btnAddShisetsuNyutaisho = function () {
                return new UZA.Button(this.convFiledName("btnAddShisetsuNyutaisho"));
            };

            Controls.prototype.dgShisetsuNyutaishoRireki = function () {
                return new UZA.DataGrid(this.convFiledName("dgShisetsuNyutaishoRireki"));
            };

            Controls.prototype.ShisetsuNyutaishoInput = function () {
                return new UZA.Panel(this.convFiledName("ShisetsuNyutaishoInput"));
            };

            Controls.prototype.txtNyushoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtNyushoDate"));
            };

            Controls.prototype.txtTaishoDate = function () {
                return new UZA.TextBoxFlexibleDate(this.convFiledName("txtTaishoDate"));
            };

            Controls.prototype.ccdShisetsuJoho = function () {
                return new DBZ.ShisetsuJohoCommonChildDiv.ModeController(this.convFiledName("ccdShisetsuJoho"));
            };

            Controls.prototype.TenshutsusakiJohoPanel = function () {
                return new UZA.Panel(this.convFiledName("TenshutsusakiJohoPanel"));
            };

            Controls.prototype.txtHokensha = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensha"));
            };

            Controls.prototype.btnHokenshaKensaku = function () {
                return new UZA.ButtonDialog(this.convFiledName("btnHokenshaKensaku"));
            };

            Controls.prototype.txtHokensyaMeisho = function () {
                return new UZA.TextBox(this.convFiledName("txtHokensyaMeisho"));
            };

            Controls.prototype.btnShisetsuNyutaishoKakutei = function () {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoKakutei"));
            };

            Controls.prototype.btnShisetsuNyutaishoTorikeshi = function () {
                return new UZA.Button(this.convFiledName("btnShisetsuNyutaishoTorikeshi"));
            };
            return Controls;
        })();
        ShisetsuNyutaishoRirekiKanri.Controls = Controls;
    })(DBZ.ShisetsuNyutaishoRirekiKanri || (DBZ.ShisetsuNyutaishoRirekiKanri = {}));
    var ShisetsuNyutaishoRirekiKanri = DBZ.ShisetsuNyutaishoRirekiKanri;
})(DBZ || (DBZ = {}));
