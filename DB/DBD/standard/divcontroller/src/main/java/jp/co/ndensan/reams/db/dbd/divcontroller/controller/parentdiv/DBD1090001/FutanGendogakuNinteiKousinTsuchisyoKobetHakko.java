/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1090001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.viewbox.ViewStateKeys;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.report.futangendogakunintei.FutanGendogakuNinteiKanshoTsuchisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 負担限度額認定更新のお知らせ通知書個別発行のクラスです。
 *
 * @reamsid_L DBD-3570-010 wangcaho
 */
public class FutanGendogakuNinteiKousinTsuchisyoKobetHakko {

    /**
     * 負担限度額認定更新のお知らせ通知書個別発行の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onLoad(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        // TODO テストデータ準備
        ViewStateHolder.put(ViewStateKeys.負担限度額認定更新のお知らせ通知書個別発行_被保険者番号, new HihokenshaNo("L000000016"));
        ViewStateHolder.put(ViewStateKeys.負担限度額認定更新のお知らせ通知書個別発行_識別コード, new ShikibetsuCode("210000000000011"));

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.負担限度額認定更新のお知らせ通知書個別発行_被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.負担限度額認定更新のお知らせ通知書個別発行_識別コード, ShikibetsuCode.class);
        div.getCcdKaigoAtenaInfoDiv().onLoad(識別コード);

        if (被保険者番号.isEmpty()) {
            return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
        } else {
            div.getCcdKaigoShikakuKihonDiv().onLoad(被保険者番号);
        }

        div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu()
                .getTxtHenkoTsuchiBunshoNo().setValue(new RString("DBD100008"));

        boolean 減免減額 = getHandler(div).initialize(被保険者番号, 識別コード);
        if (!減免減額) {
            return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_承認処理済みのため削除不可.getMessage()).respond();
        }

        ArrayList<FutanGendogakuNintei> futanGendogakuNinteiList
                = ViewStateHolder.get(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler.介護保険負担限度額認定.リストキー, ArrayList.class);
        set負担限度額認定エリア(div, futanGendogakuNinteiList.get(0));

        List<dgChohyoSentaku_Row> rowList = new ArrayList<>();
        for (FutanGendogakuNintei futanGendogakuNintei : futanGendogakuNinteiList) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(new RString(futanGendogakuNintei.get履歴番号()));
            rowList.add(row);
        }
        div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().setDataSource(rowList);
        div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD()
                .setValue(RDate.getNowDate());
        div.setListIndex(new RString("0"));
        div.getBttZenRireki().setDisabled(true);
        if (1 == futanGendogakuNinteiList.size()) {
            div.getBttGoRireki().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    private FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler getHandler(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        return new FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler(div);
    }

    private FutanGendogakuNinteiKousinTsuchisyoKobetHakkoValidationHandler getValidationHandler() {
        return new FutanGendogakuNinteiKousinTsuchisyoKobetHakkoValidationHandler();
    }

    private void set負担限度額認定エリア(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div, FutanGendogakuNintei futanGendogakuNintei) {
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtKeqteiKubunn().setValue(KetteiKubun.toValue(futanGendogakuNintei.get決定区分()).get名称());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtSinnseiRiyuu().setValue(
                ShinseiRiyuKubun.toValue(futanGendogakuNintei.get申請理由区分()).get名称());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtFutanDankai().setValue(
                RiyoshaFutanDankai.toValue(futanGendogakuNintei.get利用者負担段階()).get名称());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtKyusoti().setValue(KyuSochishaKubun.toValue(futanGendogakuNintei.get旧措置者区分()).get名称());
        if (futanGendogakuNintei.is境界層該当者区分()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtKyoukaiso().setValue(new RString("該当"));
        } else {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtKyoukaiso().setValue(new RString("非該当"));
        }
        if (futanGendogakuNintei.is激変緩和措置対象者区分()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtGekihenKanwa().setValue(new RString("対象者"));
        } else {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtGekihenKanwa().setValue(new RString("対象者以外"));
        }
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtSinnseiDate().setValue(new RDate(futanGendogakuNintei.get申請年月日().toString()));
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtKeqteiDate().setValue(new RDate(futanGendogakuNintei.get決定年月日().toString()));
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtTekiyouDate().setValue(new RDate(futanGendogakuNintei.get適用開始年月日().toString()));
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtYuukouKigenDate().setValue(new RDate(futanGendogakuNintei.get適用終了年月日().toString()));
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtShokuhiNum().setValue(futanGendogakuNintei.get食費負担限度額());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtYunittoketaKoshitsuNum().setValue(futanGendogakuNintei.getユニット型個室());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtYunittoketaJyunKoshitsuNum().setValue(futanGendogakuNintei.getユニット型準個室());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtJuuraiKoshitsuLNum().setValue(futanGendogakuNintei.get従来型個室_老健_療養等());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtJuuraiKoshitsuTNum().setValue(futanGendogakuNintei.get従来型個室_特養等());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtTkutokosituNum().setValue(futanGendogakuNintei.get多床室());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtFushouninRiyuLine().setValue(futanGendogakuNintei.get非承認理由());
        div.setRirekiNo(new RString(futanGendogakuNintei.get履歴番号()));
    }

    /**
     * 「前履歴を表示する」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnZenrireki(
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        div.getBttGoRireki().setDisabled(false);
        int listIndex = Integer.valueOf(div.getListIndex().toString()) - 1;
        if (listIndex == 0) {
            div.getBttZenRireki().setDisabled(true);
        }
        div.setListIndex(new RString(listIndex));
        ArrayList<FutanGendogakuNintei> futanGendogakuNinteiList
                = ViewStateHolder.get(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler.介護保険負担限度額認定.リストキー, ArrayList.class);
        set負担限度額認定エリア(div, futanGendogakuNinteiList.get(listIndex));
        return ResponseData.of(div).respond();
    }

    /**
     * 「前履歴を表示する」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnGorireki(
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        int listIndex = Integer.valueOf(div.getListIndex().toString()) + 1;
        ArrayList<FutanGendogakuNintei> futanGendogakuNinteiList
                = ViewStateHolder.get(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler.介護保険負担限度額認定.リストキー, ArrayList.class);
        set負担限度額認定エリア(div, futanGendogakuNinteiList.get(listIndex));
        div.getBttZenRireki().setDisabled(false);
        if (listIndex == futanGendogakuNinteiList.size() - 1) {
            div.getBttGoRireki().setDisabled(true);
        }
        div.setListIndex(new RString(listIndex));
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnPublish(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor出力チェックボックス(pairs, div);
        if (div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()) {
            getValidationHandler().validateFor文書番号の必須入力(pairs, div);
            getValidationHandler().validateFor発行日の必須入力(pairs, div);
        }

        HihokenshaNo 被保険者番号 = ViewStateHolder.get(ViewStateKeys.負担限度額認定更新のお知らせ通知書個別発行_被保険者番号, HihokenshaNo.class);
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.負担限度額認定更新のお知らせ通知書個別発行_識別コード, ShikibetsuCode.class);
        RDate 発行日 = div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu()
                .getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().getValue();
        RString 文書番号 = div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu()
                .getHenkoTsuchiKobetsu().getTxtHenkoTsuchiBunshoNo().getValue();

        FutanGendogakuNinteiKanshoTsuchisho futanGendogakuNinteiKanshoTsuchisho = FutanGendogakuNinteiKanshoTsuchisho.createInstance();
        SourceDataCollection sourceDataCollection = futanGendogakuNinteiKanshoTsuchisho.publish(
                被保険者番号, 識別コード, Integer.valueOf(div.getRirekiNo().toString()), 発行日, 文書番号);

        return ResponseData.of(sourceDataCollection).respond();
    }

    /**
     * 「世帯情報を表示する」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnShotaiJohou(
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.負担限度額認定更新のお知らせ通知書個別発行_識別コード, ShikibetsuCode.class);
        div.setNowDate(RDate.getNowDate().toDateString());
        div.setShikibetsuCode(new RString(識別コード.toString()));
        return ResponseData.of(div).respond();
    }
}
