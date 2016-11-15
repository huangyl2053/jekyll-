/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufubunruikubun.ShiharaiHohoKinoKubun;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/**
 * PaymentDate_支払日設定のハンドラクラスです。
 *
 * @reamsid_L DBC-4470-010 wangkanglei
 */
public class PaymentDateHandler {

    private final PaymentDateDiv div;
    private static final ReportId 事業高額決定通知書 = new ReportId(new RString("DBC100061_JigyoKogakuKetteiTsuchisho"));
    private static final ReportId 高額決定通知書 = new ReportId(new RString("DBC100007_KogakuKetteiTsuchiSho"));
    private static final ReportId 高額合算決定通知書 = new ReportId(new RString("DBC100053_GassanKetteiTsuchisho"));
    private static final ReportId 償還決定通知書 = new ReportId(new RString("DBC100002_ShokanKetteiTsuchiSho"));
    private static final RString 支払期間FROM = new RString("支払期間FROM");
    private static final RString 支払期間TO = new RString("支払期間TO");
    private static final RString 開始時間 = new RString("開始時間");
    private static final RString 終了時間 = new RString("終了時間");
    private static final RString 有 = new RString("1");
    private static final RString 無 = new RString("0");
    private static final RString 支払予定日印字有無 = new RString("支払予定日印字有無");
    private static final RString 事業高額 = new RString("事業高額");
    private static final RString 高額介護 = new RString("高額介護");
    private static final RString 高額合算 = new RString("高額合算");
    private static final RString 償還払 = new RString("償還払");
    private static final RString STR_0000 = new RString("0000");
    private static final RString 更新しないKEY = new RString("1");
    private static final RString 支払場所 = new RString("支払場所");

    /**
     * コンストラクタです。
     *
     * @param div PaymentDateDiv
     */
    public PaymentDateHandler(PaymentDateDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return PaymentDateDiv
     */
    public static PaymentDateHandler of(PaymentDateDiv div) {
        return new PaymentDateHandler(div);
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param 支払方法機能区分 RString
     */
    public void onLoad(RString 支払方法機能区分) {
        ChohyoSeigyoHanyoManager manager = new ChohyoSeigyoHanyoManager();
        List<ReportId> idList = new ArrayList<>();
        idList.add(事業高額決定通知書);
        idList.add(高額決定通知書);
        idList.add(高額合算決定通知書);
        idList.add(償還決定通知書);

        List<ChohyoSeigyoHanyo> entityList = manager.get表示制御に必要な情報(
                SubGyomuCode.DBC介護給付,
                idList,
                new FlexibleYear(STR_0000),
                支払予定日印字有無);

        RString 事業高額決定通知書_支払予定日印字有無 = 無;
        RString 高額決定通知書_支払予定日印字有無 = 無;
        RString 高額合算決定通知書_支払予定日印字有無 = 無;
        RString 償還決定通知書_支払予定日印字有無 = 無;
        for (ChohyoSeigyoHanyo entity : entityList) {
            if (entity.get帳票分類ID().equals(事業高額決定通知書)) {
                事業高額決定通知書_支払予定日印字有無 = entity.get設定値();
            } else if (entity.get帳票分類ID().equals(高額決定通知書)) {
                高額決定通知書_支払予定日印字有無 = entity.get設定値();
            } else if (entity.get帳票分類ID().equals(高額合算決定通知書)) {
                高額合算決定通知書_支払予定日印字有無 = entity.get設定値();
            } else if (entity.get帳票分類ID().equals(償還決定通知書)) {
                償還決定通知書_支払予定日印字有無 = entity.get設定値();
            }
        }

        RString 名称 = ShiharaiHohoKinoKubun.toValue(支払方法機能区分).get名称();
        if (事業高額.equals(名称)) {
            if (!有.equals(事業高額決定通知書_支払予定日印字有無)) {
                div.getPayToKoza().setDisplayNone(true);
            }
        } else if (高額介護.equals(名称)) {
            if (!有.equals(高額決定通知書_支払予定日印字有無)) {
                div.getPayToKoza().setDisplayNone(true);
            }
        } else if (高額合算.equals(名称)) {
            if (!有.equals(高額合算決定通知書_支払予定日印字有無)) {
                div.getPayToKoza().setDisplayNone(true);
            }
        } else if (償還払.equals(名称) && !有.equals(償還決定通知書_支払予定日印字有無)) {
            div.getPayToKoza().setDisplayNone(true);
        }
        div.getPayToMadoguchi().getRadIkkatsuKoshinKubun().setSelectedKey(更新しないKEY);
        窓口払いエリア制御(true);
    }

    /**
     * 入力チェックのメソッドます。
     *
     * @return ResponseData
     */
    public ValidationMessageControlPairs getCheckMessage() {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.get支払期間FROM() != null
                && div.get支払期間TO() != null
                && div.get支払期間TO().isBefore(div.get支払期間FROM())) {

            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    DbzErrorMessages.期間が不正_未来日付不可, 支払期間FROM.toString(), 支払期間TO.toString()),
                    div.getPayToMadoguchi().getTxtShiharaiDateRange()));

        }
        if (div.get終了時間() != null
                && div.get開始時間() != null
                && div.get終了時間().isBefore(div.get開始時間())) {
            pairs.add(new ValidationMessageControlPair(new IdocheckMessages(
                    UrErrorMessages.期間が不正_追加メッセージあり２, 開始時間.toString(), 終了時間.toString()),
                    div.getPayToMadoguchi().getTxtShiharaiKaishiTime(),
                    div.getPayToMadoguchi().getTxtShiharaiShuryoTime()));
        }
        if (!is更新しないを選択した()) {
            if (RString.isNullOrEmpty(div.getPayToMadoguchi().getTxtShiharaiBasho().getValue())) {
                pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 支払場所.toString()),
                        div.getPayToMadoguchi().getTxtShiharaiBasho()));
            }
            if (div.getPayToMadoguchi().getTxtShiharaiDateRange().getFromValue() == null) {
                pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 支払期間FROM.toString()),
                        div.getPayToMadoguchi().getTxtShiharaiDateRange()));
            }
            if (div.getPayToMadoguchi().getTxtShiharaiDateRange().getToValue() == null) {
                pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 支払期間TO.toString()),
                        div.getPayToMadoguchi().getTxtShiharaiDateRange()));

            }
            if (div.getPayToMadoguchi().getTxtShiharaiKaishiTime().getValue() == null) {
                pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 開始時間.toString()),
                        div.getPayToMadoguchi().getTxtShiharaiKaishiTime()));
            }
            if (div.getPayToMadoguchi().getTxtShiharaiShuryoTime().getValue() == null) {
                pairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.必須, 終了時間.toString()),
                        div.getPayToMadoguchi().getTxtShiharaiShuryoTime()));
            }
        }
        return pairs;
    }

    /**
     * 窓口払い一括更新区分制御
     */
    public void 窓口払い一括更新区分制御() {
        窓口払いエリア制御(is更新しないを選択した());
    }

    private boolean is更新しないを選択した() {
        return 更新しないKEY.equals(div.getPayToMadoguchi().getRadIkkatsuKoshinKubun().getSelectedKey());
    }

    private void 窓口払いエリア制御(boolean 入力不可) {
        div.getPayToMadoguchi().getTxtShiharaiBasho().setDisabled(入力不可);
        div.getPayToMadoguchi().getTxtShiharaiDateRange().setDisabled(入力不可);
        div.getPayToMadoguchi().getTxtShiharaiKaishiTime().setDisabled(入力不可);
        div.getPayToMadoguchi().getTxtShiharaiShuryoTime().setDisabled(入力不可);
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            this.message = message.getMessage().replace(replacements);
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
