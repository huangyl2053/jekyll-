/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA4030011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.tekiyojogaishadaichojoho.TekiyoJogaishaDaichoJoho;
import jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho.TekiyojogaishaDaichoItem;
import jp.co.ndensan.reams.db.dba.business.report.tekiyojogaishadaicho.TekiyojogaishaDaichoReportJoho;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA4030011.TeikiyoJogaishaShokaiDiv;
import jp.co.ndensan.reams.db.dba.service.core.tekiyojogaishadaichojoho.TekiyoJogaishaDaichoJohoFinder;
import jp.co.ndensan.reams.db.dba.service.report.tekiyojogaishadaicho.TekiyojogaishaDaichoPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.ur.urz.definition.message.UrQuestionMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.message.QuestionMessage;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 適用除外者照会のクラスです。
 *
 * @reamsid_L DBA-0412-030 lishengli
 */
public class TeikiyoJogaishaShokai {

    /**
     * 適用除外者照会の初期化です。
     *
     * @param div TeikiyoJogaishaShokaiDiv
     * @return ResponseData<TeikiyoJogaishaShokaiDiv>
     */
    public ResponseData<TeikiyoJogaishaShokaiDiv> onLoad(TeikiyoJogaishaShokaiDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        if (key != null) {
            識別コード = key.get識別コード();
        }
        div.getShikakuKihonJoho().getCcdShikakuJoho().initialize(識別コード);
        div.getShikakuKihonJoho().getCcdKaigoAtenaInfo().initialize(識別コード);
        div.getTeikiyoJogaishaJoho().getCcdTekiyoJogaiRireki().initialize(識別コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 施設情報エリアの初期化です。
     *
     * @param div TeikiyoJogaishaShokaiDiv
     * @return ResponseData<TeikiyoJogaishaShokaiDiv>
     */
    public ResponseData<TeikiyoJogaishaShokaiDiv> onOpen(TeikiyoJogaishaShokaiDiv div) {
        if (RString.isNullOrEmpty(div.getHasOpen())) {
            TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
            ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
            if (key != null) {
                識別コード = key.get識別コード();
            }
            div.getShisetsuJoho().getCcdShisetsuNyuTaishoRireki().initialize(識別コード);
            div.setHasOpen(new RString("Open"));
            div.getShisetsuJoho().setIsOpen(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 適用除外者台帳を発行するボタンを押下します。
     *
     * @param div TeikiyoJogaishaShokaiDiv
     * @return ResponseData<SourceDataCollection>
     */
    public ResponseData<SourceDataCollection> onClick_btnReportPublish(TeikiyoJogaishaShokaiDiv div) {
        TaishoshaKey key = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        ShikibetsuCode 識別コード = ShikibetsuCode.EMPTY;
        if (key != null) {
            識別コード = key.get識別コード();
        }
        List<TekiyoJogaishaDaichoJoho> list = TekiyoJogaishaDaichoJohoFinder.createInstance().getTekiyoJogaishaDaichoJoho(識別コード).records();
        return ResponseData.of(new TekiyojogaishaDaichoPrintService().print(get適用除外者台帳情報(list))).respond();
    }

    /**
     * 適用除外者台帳を発行するボタンを押下前のCheckです。
     *
     * @param div TeikiyoJogaishaShokaiDiv
     * @return ResponseData<TeikiyoJogaishaShokaiDiv>
     */
    public ResponseData<TeikiyoJogaishaShokaiDiv> onClick_btnCheck(TeikiyoJogaishaShokaiDiv div) {
        if (!ResponseHolder.isReRequest()) {
            QuestionMessage message = new QuestionMessage(UrQuestionMessages.処理実行の確認.getMessage().getCode(),
                    UrQuestionMessages.処理実行の確認.getMessage().evaluate());
            return ResponseData.of(div).addMessage(message).respond();
        }
        return ResponseData.of(div).respond();
    }

    private TekiyojogaishaDaichoReportJoho get適用除外者台帳情報(List<TekiyoJogaishaDaichoJoho> list) {
        return new TekiyojogaishaDaichoReportJoho(getBodyItemList(list));
    }

    private RString chickNull(RString temp) {
        return temp == null ? RString.EMPTY : temp;
    }

    private List<TekiyojogaishaDaichoItem> getBodyItemList(List<TekiyoJogaishaDaichoJoho> list) {
        List<TekiyojogaishaDaichoItem> bodyItemList = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                FlexibleDate 生年月日 = new FlexibleDate(list.get(0).get生年月日());
                TekiyojogaishaDaichoItem item = new TekiyojogaishaDaichoItem(
                        chickNull(list.get(0).get印刷日時()),
                        list.get(0).getタイトル(),
                        chickNull(list.get(0).get市町村コード()),
                        chickNull(list.get(0).get市町村名称()),
                        生年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString(),
                        chickNull(list.get(0).get性別()),
                        chickNull(list.get(0).get世帯コード()),
                        chickNull(list.get(0).get識別コード()),
                        chickNull(list.get(0).get氏名カナ()),
                        chickNull(list.get(0).get地区タイトル1()),
                        chickNull(list.get(0).get地区コード1()),
                        chickNull(list.get(0).get氏名()),
                        chickNull(list.get(0).get状態()),
                        chickNull(list.get(0).get電話番号タイトル()),
                        chickNull(list.get(0).get地区タイトル2()),
                        chickNull(list.get(0).get地区コード2()),
                        chickNull(list.get(0).get住所1()),
                        chickNull(list.get(0).get住所タイトル1()),
                        chickNull(list.get(0).get電話番号１()),
                        chickNull(list.get(0).get電話番号２()),
                        chickNull(list.get(0).get地区タイトル3()),
                        chickNull(list.get(0).get地区コード3()),
                        chickNull(list.get(0).get住所コード()),
                        chickNull(list.get(0).get行政区タイトル()),
                        chickNull(list.get(0).get行政区コード()),
                        chickNull(list.get(0).get住所2()),
                        chickNull(list.get(0).get住所タイトル2()),
                        chickNull(list.get(0).get住所コード2()),
                        getNo(list.get(i).get適用年月日(), list.get(i).get適用届出年月日(), list.get(i).get適用除外適用事由コード(),
                                list.get(i).get適用除外適用事由名称(), list.get(i).get入所年月日(), list.get(i).get事業者名称(),
                                list.get(i).get電話番号(), list.get(i).get解除年月日(), list.get(i).get解除届出年月日(),
                                list.get(i).get適用除外解除事由コード(), list.get(i).get適用除外解除事由名称(),
                                list.get(i).get退所年月日(), list.get(i).get事業者住所(), list.get(i).get郵便番号(), i),
                        chickNull(list.get(i).get適用年月日()),
                        chickNull(list.get(i).get適用届出年月日()),
                        chickNull(list.get(i).get適用除外適用事由コード()),
                        chickNull(list.get(i).get適用除外適用事由名称()),
                        chickNull(list.get(i).get入所年月日()),
                        list.get(i).get事業者名称() == null ? RString.EMPTY : list.get(i).get事業者名称().getColumnValue(),
                        list.get(i).get電話番号() == null ? RString.EMPTY : list.get(i).get電話番号().getColumnValue(),
                        chickNull(list.get(i).get解除年月日()),
                        chickNull(list.get(i).get解除届出年月日()),
                        chickNull(list.get(i).get適用除外解除事由コード()),
                        chickNull(list.get(i).get適用除外解除事由名称()),
                        chickNull(list.get(i).get退所年月日()),
                        chickNull(list.get(i).get事業者住所()),
                        chickNull(list.get(i).get郵便番号()));
                bodyItemList.add(item);
            }
        }
        return bodyItemList;
    }

    private RString getNo(RString 適用年月日, RString 適用届出年月日, RString 適用除外適用事由コード, RString 適用除外適用事由名称,
            RString 入所年月日, AtenaMeisho 事業者名称, TelNo 電話番号, RString 解除年月日, RString 解除届出年月日, RString 適用除外解除事由コード,
            RString 適用除外解除事由名称, RString 退所年月日, RString 事業者住所, RString 郵便番号, int size) {
        if (size == 0 && RString.isNullOrEmpty(適用年月日) && RString.isNullOrEmpty(適用届出年月日) && RString.isNullOrEmpty(適用除外適用事由コード)
                && RString.isNullOrEmpty(適用除外適用事由名称) && RString.isNullOrEmpty(入所年月日) && (事業者名称 == null || 事業者名称.isEmpty())
                && (電話番号 == null || 電話番号.isEmpty()) && RString.isNullOrEmpty(解除年月日) && RString.isNullOrEmpty(解除届出年月日)
                && RString.isNullOrEmpty(適用除外解除事由コード) && RString.isNullOrEmpty(適用除外解除事由名称) && RString.isNullOrEmpty(退所年月日)
                && RString.isNullOrEmpty(事業者住所) && RString.isNullOrEmpty(郵便番号)) {
            return RString.EMPTY;
        }
        return new RString(String.valueOf(size + 1));
    }
}
