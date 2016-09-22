/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.FutanGendogakuNintei.FutanGendogakuNintei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.hikazenenkintaishosha.HikazeNenkinTaishosha;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KyoshitsuShubetsu;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.HaigushaKazeiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.YochokinShinkokuKubun;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 共有子Div「負担限度額認定」の状態を変更するクラスです。
 *
 * @reamsid_L DBD-3560-030 huangh
 */
public class FutanGendogakuNinteiHandler {

    private final FutanGendogakuNinteiDiv div;
    private final RString TRUE = new RString("0");
    private final RString FALSE = new RString("1");
    private final RString KAITO = new RString("該当");
    private final RString KEY0 = new RString("0");
    private final RString KEY1 = new RString("1");
    private final RString KEY2 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div FutanGendogakuNinteiDiv
     */
    public FutanGendogakuNinteiHandler(FutanGendogakuNinteiDiv div) {
        this.div = div;
    }

    /**
     * 表示リスト取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return boolean
     */
    public List<FutanGendogakuNintei> 表示リスト取得(HihokenshaNo 被保険者番号) {
        return FutanGendogakuNinteiManager.createInstance().get負担限度額認定リストBy被保険者番号(被保険者番号);
    }
    
    /**
     * 共有子Divの状態を初期化します。
     *
     * @param futanGendogakuNinteiList List<FutanGendogakuNintei>
     */
    public void initialize(List<FutanGendogakuNintei> futanGendogakuNinteiList) {

        List<dgFutanGendogakuNinteiList_Row> dgList = new ArrayList<>();
        for (FutanGendogakuNintei futanGendogakuNintei : futanGendogakuNinteiList) {
            dgFutanGendogakuNinteiList_Row row = new dgFutanGendogakuNinteiList_Row();

            TextBoxFlexibleDate 申請日 = new TextBoxFlexibleDate();
            申請日.setValue(futanGendogakuNintei.get申請年月日());
            row.setShinseiDate(申請日);

            TextBoxFlexibleDate 決定日 = new TextBoxFlexibleDate();
            決定日.setValue(futanGendogakuNintei.get決定年月日());
            row.setKetteiDate(決定日);

            try {
                row.setKetteiKubun(KetteiKubun.toValue(futanGendogakuNintei.get決定区分()).get名称());
            } catch (IllegalArgumentException e) {
                row.setKetteiKubun(RString.EMPTY);
            }
            TextBoxFlexibleDate 適用日 = new TextBoxFlexibleDate();
            適用日.setValue(futanGendogakuNintei.get適用開始年月日());
            row.setTekiyoDate(適用日);

            TextBoxFlexibleDate 有効期限 = new TextBoxFlexibleDate();
            有効期限.setValue(futanGendogakuNintei.get適用終了年月日());
            row.setYukoKigen(有効期限);

            try {
                row.setShinseiRiyu(ShinseiRiyuKubun.toValue(futanGendogakuNintei.get申請理由区分()).get名称());
            } catch (IllegalArgumentException e) {
                row.setShinseiRiyu(RString.EMPTY);
            }
            row.setFushoninRiyu(futanGendogakuNintei.get非承認理由());
            try {
                row.setFutanDankai(RiyoshaFutanDankai.toValue(futanGendogakuNintei.get利用者負担段階()).get名称());
            } catch (IllegalArgumentException e) {
                row.setFutanDankai(RString.EMPTY);
            }

            row.setKyushochisha(futanGendogakuNintei.get旧措置者区分());
            row.setKyoshitsuType(futanGendogakuNintei.get居室種別());
            row.setKyokaiso(futanGendogakuNintei.is境界層該当者区分() ? TRUE : FALSE);
            row.setGekihenKanwa(futanGendogakuNintei.is激変緩和措置対象者区分() ? TRUE : FALSE);

            TextBoxNum 食費 = new TextBoxNum();
            食費.setValue(futanGendogakuNintei.get食費負担限度額());
            row.setShokuhi(食費);

            TextBoxNum ユニット型個室 = new TextBoxNum();
            ユニット型個室.setValue(futanGendogakuNintei.getユニット型個室());
            row.setUnitKoshitsu(ユニット型個室);

            TextBoxNum ユニット型準個室 = new TextBoxNum();
            ユニット型準個室.setValue(futanGendogakuNintei.getユニット型準個室());
            row.setUnitJunKoshitsu(ユニット型準個室);

            TextBoxNum 多床室 = new TextBoxNum();
            多床室.setValue(futanGendogakuNintei.get多床室());
            row.setTashoshitsu(多床室);

            TextBoxNum 従来型個室_特養等 = new TextBoxNum();
            従来型個室_特養等.setValue(futanGendogakuNintei.get従来型個室_特養等());
            row.setJuraigataKoshitsuTokuyo(従来型個室_特養等);

            TextBoxNum 来型個室_老健_療養等 = new TextBoxNum();
            来型個室_老健_療養等.setValue(futanGendogakuNintei.get従来型個室_老健_療養等());
            row.setJuraigataKoshitsuRoken(来型個室_老健_療養等);

            dgList.add(row);
        }

        div.getDgFutanGendogakuNinteiList()
                .setDataSource(dgList);

        div.getFutanGendogakuNinteiDetail().setDisplayNone(true);
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param list ArrayList<FutanGendogakuNintei>
     * @param HiKazeiNenkinjoho
     */
    public void 詳細表示(ArrayList<FutanGendogakuNintei> list, RString HiKazeiNenkinjoho) {

        div.getFutanGendogakuNinteiDetail().setDisplayNone(false);
        FutanGendogakuNintei futanGendogakuNintei = list.get(div.getDgFutanGendogakuNinteiList().getClickedRowId());
        if (futanGendogakuNintei != null) {
            div.getFutanGendogakuNinteiDetail().getTxtShinseiDate().setValue(futanGendogakuNintei.get申請年月日());
            div.getFutanGendogakuNinteiDetail().getTxtShinseiRiyu().
                    setValue(div.getDgFutanGendogakuNinteiList().getClickedItem().getShinseiRiyu());
            // 遺族年金受給申告
            List<RString> IzokuNenkinJukyuShinkokukeys = new ArrayList<>();
            if (futanGendogakuNintei.get遺族年金受給申告()) {
                IzokuNenkinJukyuShinkokukeys.add(new RString("key0"));
            }
            div.getFutanGendogakuNinteiDetail().getIzokuNenkinJukyuShinkoku().setSelectedItemsByKey(IzokuNenkinJukyuShinkokukeys);
            // 障害年金受給申告
            List<RString> ShogaiNenkinJukyuShinkokukeys = new ArrayList<>();
            if (futanGendogakuNintei.get障害年金受給申告()) {
                ShogaiNenkinJukyuShinkokukeys.add(new RString("key0"));
            }
            div.getFutanGendogakuNinteiDetail().getShogaiNenkinJukyuShinkoku().setSelectedItemsByKey(ShogaiNenkinJukyuShinkokukeys);
            // 非課税年金情報
            div.getFutanGendogakuNinteiDetail().getHiKazeiNenkinjoho().setValue(HiKazeiNenkinjoho);
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtKetteiDate().
                    setValue(futanGendogakuNintei.get決定年月日());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtKetteiKubun().
                    setValue(div.getDgFutanGendogakuNinteiList().getClickedItem().getKetteiKubun());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtTekiyoDate().
                    setValue(futanGendogakuNintei.get適用開始年月日());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtYukokigenDate().
                    setValue(futanGendogakuNintei.get適用終了年月日());
            try {
                div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtKyushochisha().
                        setValue(KyuSochishaKubun.toValue(futanGendogakuNintei.get旧措置者区分()).get名称());
            } catch (IllegalArgumentException e) {
                div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtKyushochisha().
                        setValue(RString.EMPTY);
            }
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtFutanDankai().
                    setValue(div.getDgFutanGendogakuNinteiList().getClickedItem().getFutanDankai());
            try {
                div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtKyoshitsuType().
                        setValue(KyoshitsuShubetsu.toValue(futanGendogakuNintei.get居室種別()).get名称());
            } catch (IllegalArgumentException e) {
                div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtKyoshitsuType().
                        setValue(RString.EMPTY);
            }
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtKyokaiso().
                    setValue(futanGendogakuNintei.is境界層該当者区分() ? KAITO : RString.EMPTY);
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtGekihenKanwa().
                    setValue(futanGendogakuNintei.is激変緩和措置対象者区分() ? KAITO : RString.EMPTY);
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getFutanGendogaku().getTxtShokuhi().
                    setValue(futanGendogakuNintei.get食費負担限度額());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getFutanGendogaku().getTxtUnitKoshitsu().
                    setValue(futanGendogakuNintei.getユニット型個室());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getFutanGendogaku().getTxtUnitJunKoshitsu().
                    setValue(futanGendogakuNintei.getユニット型準個室());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getFutanGendogaku().getTxtTashoshitsu().
                    setValue(futanGendogakuNintei.get多床室());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getFutanGendogaku().getTxtJuraigataKoshitsuTokuyo().
                    setValue(futanGendogakuNintei.get従来型個室_特養等());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getFutanGendogaku().getTxtJuraigataKoshitsuRoken().
                    setValue(futanGendogakuNintei.get従来型個室_老健_療養等());
            div.getFutanGendogakuNinteiDetail().getFutanGendogakuNinteiRiyoshaFutan().getTxtFushoninRiyu().
                    setValue(futanGendogakuNintei.get非承認理由());
            div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getRadHaigushaUmu().
                    setSelectedKey(futanGendogakuNintei.is配偶者の有無() ? KEY1 : KEY2);
            if (futanGendogakuNintei.get配偶者識別コード() != null) {
                div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShikibetsuCode().
                        setDomain(futanGendogakuNintei.get配偶者識別コード());
            } else {
                div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShikibetsuCode().clearDomain();
            }
            div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShimeiKana().
                    setValue(futanGendogakuNintei.get配偶者氏名カナ().value());
            div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShimei().
                    setValue(futanGendogakuNintei.get配偶者氏名().value());
            div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtShimei().
                    setValue(futanGendogakuNintei.get配偶者氏名().value());
            div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtBirthday().
                    setValue(futanGendogakuNintei.get配偶者生年月日());
            div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtRenrakusaki().
                    setDomain(new TelNo(futanGendogakuNintei.get配偶者連絡先()));
            if (futanGendogakuNintei.get配偶者住所() != null) {
                div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtJusho1().
                        setDomain(futanGendogakuNintei.get配偶者住所());
            } else {
                div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtJusho1().clearDomain();
            }
            if (futanGendogakuNintei.get配偶者住所２() != null) {
                div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtGenjusho().
                        setDomain(futanGendogakuNintei.get配偶者住所２());
            } else {
                div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getTxtGenjusho().clearDomain();
            }
            div.getFutanGendogakuNinteiDetail().getHaigushaJoho().getRadKazeiKubun().
                    setSelectedKey(HaigushaKazeiKubun.課税.getコード().equals(futanGendogakuNintei.get配偶者課税区分()) ? KEY0 : KEY1);

            List<RString> keys = new ArrayList<>();
            if (YochokinShinkokuKubun.以下.getコード().equals(futanGendogakuNintei.get預貯金申告区分())) {
                keys.add(KEY0);
            }
            div.getFutanGendogakuNinteiDetail().getYochokinjoho().getChkYochokin().
                    setSelectedItemsByKey(keys);
            div.getFutanGendogakuNinteiDetail().getYochokinjoho().getTxtYochokin().
                    setValue(futanGendogakuNintei.get預貯金額());
            div.getFutanGendogakuNinteiDetail().getYochokinjoho().getTxtYukaShoken().
                    setValue(futanGendogakuNintei.get有価証券評価概算額());
            div.getFutanGendogakuNinteiDetail().getYochokinjoho().getTxtSonota().
                    setValue(futanGendogakuNintei.getその他金額());
        }
    }
}
