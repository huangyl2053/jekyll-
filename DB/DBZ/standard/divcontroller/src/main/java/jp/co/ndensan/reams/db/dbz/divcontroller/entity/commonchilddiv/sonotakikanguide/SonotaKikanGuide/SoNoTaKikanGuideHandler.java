/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.sonotakikanguide.SonotaKikanGuide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuide;
import jp.co.ndensan.reams.db.dbz.business.core.sonotakikanguide.SoNoTaKikanGuideModel;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaItakuKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.IMessageGettable;
import jp.co.ndensan.reams.uz.uza.message.IValidationMessage;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * SoNoTaKikanGuideHandler のクラスファイル。
 *
 * @reamsid_L DBE-3000-050 wangkun
 */
public class SoNoTaKikanGuideHandler {

    private static final RString 含まない = new RString("key0");
    private final SonotaKikanGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div ShikakuHenkoRirekiDiv
     */
    public SoNoTaKikanGuideHandler(SonotaKikanGuideDiv div) {
        this.div = div;
    }

    /**
     * その他機関選択ガイドを初期化処理します。
     */
    public void load() {
        SoNoTaKikanGuideModel その他機関 = ViewStateHolder.get(ViewStateKeys.その他機関選択ガイド_モード, SoNoTaKikanGuideModel.class);
        if (その他機関 != null) {
            if (その他機関.get業務分類() != null) {
                div.getCcdHokenshaList().loadHokenshaList(その他機関.get業務分類());
            }
            if (!RString.isNullOrEmpty(その他機関.get市町村コード())) {
                RString 市町村コード = その他機関.get市町村コード();
                div.getCcdHokenshaList().setSelectedShichosonIfExist(new LasdecCode(市町村コード));
            }
            if (!RString.isNullOrEmpty(その他機関.getその他機関コード())) {
                div.getTxtSonotaKikanCodefrom().setValue(その他機関.getその他機関コード());
                div.getTxtSonotaKikanCodeto().setValue(その他機関.getその他機関コード());
            } else {
                div.getTxtSonotaKikanCodefrom().clearValue();
                div.getTxtSonotaKikanCodeto().clearValue();
            }
        }

        div.getTxtSonotaKikanName().clearValue();
        div.getRadHaisi().setSelectedKey(含まない);
        set調査委託先区();
        div.getTxtMaxDisp().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数上限,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * その他機関選択ガイド一覧データを作成処理します。
     *
     * @param businessList その他機関情報のビジネスリスト
     */
    public void set一覧データ(List<SoNoTaKikanGuide> businessList) {
        List<dgSonotaKikanIchiran_Row> rowList = new ArrayList();
        for (SoNoTaKikanGuide business : businessList) {
            RString 調査委託名称 = RString.EMPTY;
            if (!business.get調査委託区分().isNull() && !business.get調査委託区分().isEmpty()) {
                調査委託名称 = ChosaItakuKubunCode.toValue(business.get調査委託区分()).get名称();
            }
            rowList.add(new dgSonotaKikanIchiran_Row(business.getその他機関コード(),
                    business.get機関名称(), business.get住所(), business.get電話番号(),
                    調査委託名称));
        }
        div.getDgSonotaKikanIchiran().setDataSource(rowList);
    }

    /**
     * その他機関コードFromとその他機関コードToの大小関係チェックです。
     * 面.その他機関コードFromと画面.その他機関コードTo両方とも入力される場合、 その他機関コードFrom
     * >その他機関コードToの時、エラーとする。
     *
     * @return ValidationMessageControlPairs バリデーション結果
     */
    public ValidationMessageControlPairs 大小関係チェック() {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (!div.getTxtSonotaKikanCodefrom().getValue().isEmpty()
                && !div.getTxtSonotaKikanCodeto().getValue().isEmpty()
                && div.getTxtSonotaKikanCodefrom().getValue().compareTo(div.getTxtSonotaKikanCodeto().getValue()) > 0) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.大小関係が不正, "その他機関コード")));
        }
        return validPairs;
    }

    /**
     * その他機関一覧データグリッドが0件の場合、エラーとする。
     *
     * @param businessList その他機関情報のビジネスクラスリスト
     * @return ValidationMessageControlPairs バリデーション結果
     */
    public ValidationMessageControlPairs その他機関一覧データなしチェック(List<SoNoTaKikanGuide> businessList) {
        ValidationMessageControlPairs validPairs = new ValidationMessageControlPairs();
        if (businessList.isEmpty()) {
            validPairs.add(new ValidationMessageControlPair(new IdocheckMessages(UrErrorMessages.該当データなし)));
        }
        return validPairs;
    }

    private void set調査委託先区() {
        List<KeyValueDataSource> dropDownList = new ArrayList();
        dropDownList.add(new KeyValueDataSource(ChosaItakuKubunCode.保険者_市町村等.getコード(), ChosaItakuKubunCode.保険者_市町村等.get名称()));
        dropDownList.add(new KeyValueDataSource(ChosaItakuKubunCode.指定市町村事務受託法人.getコード(), ChosaItakuKubunCode.指定市町村事務受託法人
                .get名称()));
        dropDownList.add(new KeyValueDataSource(ChosaItakuKubunCode.指定居宅介護支援事業者.getコード(), ChosaItakuKubunCode.指定居宅介護支援事業者
                .get名称()));
        dropDownList.add(new KeyValueDataSource(ChosaItakuKubunCode.介護保険施設.getコード(), ChosaItakuKubunCode.介護保険施設.get名称()));
        dropDownList.add(new KeyValueDataSource(ChosaItakuKubunCode.介護支援専門員.getコード(), ChosaItakuKubunCode.介護支援専門員.get名称()));
        dropDownList.add(new KeyValueDataSource(ChosaItakuKubunCode.他市町村.getコード(), ChosaItakuKubunCode.他市町村.get名称()));
        dropDownList.add(new KeyValueDataSource(ChosaItakuKubunCode.その他.getコード(), ChosaItakuKubunCode.その他.get名称()));
        div.getDdlChosaItakusakiKubun().setDataSource(dropDownList);
        div.getDdlChosaItakusakiKubun().setSelectedKey(RString.EMPTY);
    }

    private static class IdocheckMessages implements IValidationMessage {

        private final Message message;

        public IdocheckMessages(IMessageGettable message, String... replacements) {
            if (replacements.length == 0) {
                this.message = message.getMessage();
            } else {
                this.message = message.getMessage().replace(replacements);
            }
        }

        @Override
        public Message getMessage() {
            return message;
        }
    }
}
