var __extends = this.__extends || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    __.prototype = b.prototype;
    d.prototype = new __();
};
var DBC;
(function (DBC) {
    var PaymentMethod = (function (_super) {
        __extends(PaymentMethod, _super);
        function PaymentMethod() {
            _super.apply(this, arguments);
        }
        return PaymentMethod;
    })(DBC.PaymentMethod_Design);
    DBC.PaymentMethod = PaymentMethod;
})(DBC || (DBC = {}));
