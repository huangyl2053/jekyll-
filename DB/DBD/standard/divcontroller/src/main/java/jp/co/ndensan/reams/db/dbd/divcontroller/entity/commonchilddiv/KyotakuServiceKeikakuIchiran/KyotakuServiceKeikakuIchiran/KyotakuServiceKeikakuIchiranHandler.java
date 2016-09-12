/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.KyotakuServiceKeikakuIchiran.KyotakuServiceKeikakuIchiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.JikoSakuseiKeikakuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KeikakuIraiJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KyotakuServiceKeikakuIchiranEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.KyotakuServiceMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.ServiceShuruiCodeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyotakuservicekeikakuichiran.ShuruiGendoKakuEntity;
import jp.co.ndensan.reams.db.dbd.service.core.kyotakuservicekeikakuichiran.KyotakuServiceKeikakuIchiranFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.serviceshurui.ServiceCategoryShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.YokaigoJotaiKubunSupport;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.KyotakuservicekeikakuSakuseikubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.TodokedeKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku.ZanteiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * 共有子Div「居宅計画」の状態を変更するクラスです。
 *
 * @reamsid_L DBD-3560-080 huangh
 */
public class KyotakuServiceKeikakuIchiranHandler {

    private final KyotakuServiceKeikakuIchiranDiv div;
    private final RString YUKO = new RString("有効");
    private final RString MUKO = new RString("無効");
    private final RString SHINKI_SHISEI = new RString("新規申請");
    private final RString SAI_SHISEI = new RString("再申請");
    private final RString HENKOU_SHISEI = new RString("変更申請");
    private final RString SERVICE_HENKOU = new RString("サービス変更");
    private final RString ケアマネジメント = new RString("ケアマネジメント");
    private final RString 居宅介護 = new RString("居宅介護");
    private final RString 居宅予防 = new RString("居宅予防");
    private final RString 小規模介護 = new RString("小規模介護");
    private final RString 小規模予防 = new RString("小規模予防");

    /**
     * コンストラクタです。
     *
     * @param div KyotakuServiceKeikakuIchiranDiv
     */
    public KyotakuServiceKeikakuIchiranHandler(KyotakuServiceKeikakuIchiranDiv div) {
        this.div = div;
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void initialize(HihokenshaNo 被保険者番号) {

        this.状態１();
        List<KyotakuServiceKeikakuIchiranEntity> result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().居宅サービス計画情報の取得(被保険者番号);

        if (result == null || result.isEmpty()) {
            return;
        }
        List<dgKyotakuServiceKeikakuIchiran_Row> dgList = new ArrayList<>();
        for (KyotakuServiceKeikakuIchiranEntity entity : result) {
            dgKyotakuServiceKeikakuIchiran_Row row = new dgKyotakuServiceKeikakuIchiran_Row();

            TextBoxFlexibleDate 対象年月 = new TextBoxFlexibleDate();
            対象年月.setValue(new FlexibleDate(entity.get対象年月().toDateString()));
            row.setTaishoYM(対象年月);

            row.setKeikakuSakuseiKubun(KyotakuservicekeikakuSakuseikubunCode.toValue(entity.get作成区分コード()).get名称());

            row.setJigyoshaNo(entity.get事業者番号() != null ? entity.get事業者番号().value() : RString.EMPTY);
            row.setJigyoshaName(entity.get事業者名称() != null ? entity.get事業者名称().value() : RString.EMPTY);

            if (entity.get適用開始年月日() != null) {
                TextBoxFlexibleDate 開始年月日 = new TextBoxFlexibleDate();
                開始年月日.setValue(entity.get適用開始年月日());
                row.setStartDate(開始年月日);
            }

            if (entity.get適用終了年月日() != null) {
                TextBoxFlexibleDate 終了年月日 = new TextBoxFlexibleDate();
                終了年月日.setValue(entity.get適用終了年月日());
                row.setEndDate(終了年月日);
            }

            row.setRirekiNo(new RString(String.valueOf(entity.get履歴番号())));
            Boolean 有効Flg = true;
            for (KyotakuServiceKeikakuIchiranEntity entity1 : result) {
                if (entity.get対象年月().equals(entity1.get対象年月())
                        && entity1.get履歴番号() > entity.get履歴番号()) {
                    有効Flg = false;
                }
            }

            if (有効Flg) {
                row.setYukomuko(YUKO);
            } else {
                row.setYukomuko(MUKO);
            }

            dgList.add(row);
        }

        div.getDgKyotakuServiceKeikakuIchiran().setDataSource(dgList);
    }

    /**
     * 共有子Divの状態を初期化します。
     *
     */
    public void select() {

        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHiddenHihokenshaNo());

        if (KyotakuservicekeikakuSakuseikubunCode.自己作成.get名称().
                equals(div.getDgKyotakuServiceKeikakuIchiran().getClickedItem().getKeikakuSakuseiKubun())) {
            this.状態３();
            this.selectFor自己作成(被保険者番号);

        } else {
            this.状態２();
            this.selectFor事業者作成(被保険者番号);
        }

    }

    /**
     * 計画依頼受付情報ボタンをクリンクします。
     *
     */
    public void onClick_btnKeikakuIraiUketsuke() {

        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHiddenHihokenshaNo());

        this.状態２();
        this.selectFor事業者作成(被保険者番号);
    }

    /**
     * 自己作成計画情報ボタンをクリンクします。
     *
     */
    public void onClick_btnJikosakuseiKeikaku() {

        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHiddenHihokenshaNo());

        this.状態３();
        this.selectFor自己作成(被保険者番号);
    }

    /**
     * 居宅サービス情報ボタンをクリンクします。
     *
     */
    public void onClick_btnKyotakuService() {

        HihokenshaNo 被保険者番号 = new HihokenshaNo(div.getHiddenHihokenshaNo());

        this.状態４();
        this.居宅サービス情報ボタン押下時(被保険者番号);
    }

    /**
     * 居宅サービス情報データグリッドを選択します。
     *
     */
    public void onSelect_dgKyotakuService() {

        this.状態５();
        this.居宅サービス情報データグリッドを選択();
    }

    /**
     * 種類限度額確認ボタンをクリンクします。
     *
     */
    public void onClick_btnShuruiGendoGakuKakunin() {

        this.状態６();
        this.種類限度額確認ボタン押下時();
    }

    /**
     * 状態１をします。
     *
     */
    public void to状態１() {

        this.状態１();
    }

    /**
     * 状態４をします。
     *
     */
    public void to状態４() {

        this.状態４();
    }

    private void selectFor事業者作成(HihokenshaNo 被保険者番号) {
        List<DbT4001JukyushaDaichoEntity> dbt4001Result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().認定申請中状況の取得(被保険者番号);
        if (dbt4001Result == null || dbt4001Result.isEmpty()) {
            div.getDvKeikakuIraiUketsuke().getTxtIraiNinteiShinseiJokyo().setValue(RString.EMPTY);
        } else if (JukyuShinseiJiyu.初回申請.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvKeikakuIraiUketsuke().getTxtIraiNinteiShinseiJokyo().setValue(SHINKI_SHISEI);
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())
                || JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvKeikakuIraiUketsuke().getTxtIraiNinteiShinseiJokyo().setValue(SAI_SHISEI);
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvKeikakuIraiUketsuke().getTxtIraiNinteiShinseiJokyo().setValue(HENKOU_SHISEI);
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvKeikakuIraiUketsuke().getTxtIraiNinteiShinseiJokyo().setValue(SERVICE_HENKOU);
        }

        List<KeikakuIraiJohoEntity> 計画依頼受付情報result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().計画依頼受付情報の取得(被保険者番号);

        if (計画依頼受付情報result != null && !計画依頼受付情報result.isEmpty()) {
            div.getDvKeikakuIraiUketsuke().getTxtTodokedeKubun().setValue(
                    TodokedeKubun.toValue(計画依頼受付情報result.get(0).get届出区分()).get名称());

            div.getDvKeikakuIraiUketsuke().getTxtIraiShinseiDate().setValue(計画依頼受付情報result.get(0).get届出年月日());
            if (計画依頼受付情報result.get(0).get適用開始年月日() != null && !計画依頼受付情報result.get(0).get適用開始年月日().isEmpty()) {
                div.getDvKeikakuIraiUketsuke().getTxtKeikakuTekiyoStartDate().
                        setValue(new RDate(計画依頼受付情報result.get(0).get適用開始年月日().toString()));
            } else {
                div.getDvKeikakuIraiUketsuke().getTxtKeikakuTekiyoStartDate().clearValue();
            }
            if (計画依頼受付情報result.get(0).get適用終了年月日() != null && !計画依頼受付情報result.get(0).get適用終了年月日().isEmpty()) {
                div.getDvKeikakuIraiUketsuke().getTxtIraiKeikakuTekiyoEndDate().
                        setValue(new RDate(計画依頼受付情報result.get(0).get適用終了年月日().toString()));
            } else {
                div.getDvKeikakuIraiUketsuke().getTxtIraiKeikakuTekiyoEndDate().clearValue();
            }
            div.getDvKeikakuIraiUketsuke().getTxtKeikakuSakuseiKubun().
                    setValue(KyotakuservicekeikakuSakuseikubunCode.toValue(計画依頼受付情報result.get(0).get作成区分コード()).get名称());
            div.getDvKeikakuIraiUketsuke().getTxtJigyoshaNo().setValue(計画依頼受付情報result.get(0).get計画事業者番号().value());
            div.getDvKeikakuIraiUketsuke().getTxtJigyoshaName().setValue(計画依頼受付情報result.get(0).get計画事業者名().value());
            div.getDvKeikakuIraiUketsuke().getTxtYubinNo().setValue(計画依頼受付情報result.get(0).get郵便番号());
            div.getDvKeikakuIraiUketsuke().getTxtJusho().setValue(計画依頼受付情報result.get(0).get事業者住所().value());
            div.getDvKeikakuIraiUketsuke().getTxtKanrishaName().setValue(計画依頼受付情報result.get(0).get代表者名().value());
            div.getDvKeikakuIraiUketsuke().getTxtTelNo().setDomain(計画依頼受付情報result.get(0).get電話番号());
            div.getDvKeikakuIraiUketsuke().getTxtItakusakiJigyoshaNo().setValue(計画依頼受付情報result.get(0).get委託先事業者番号().value());
            div.getDvKeikakuIraiUketsuke().getTxtItakusakiJigyoshaName().setValue(計画依頼受付情報result.get(0).get委託先事業者名().value());
            if (計画依頼受付情報result.get(0).get事業者変更年月日() != null && !計画依頼受付情報result.get(0).get事業者変更年月日().isEmpty()) {
                div.getDvKeikakuIraiUketsuke().getTxtHenkoDate().setValue(new RDate(計画依頼受付情報result.get(0).get事業者変更年月日().toString()));
            } else {
                div.getDvKeikakuIraiUketsuke().getTxtHenkoDate().clearValue();
            }
            div.getDvKeikakuIraiUketsuke().getTxtHenkoRiyu().setValue(計画依頼受付情報result.get(0).get事業者変更事由());
        }

        RString サービス種類 = RString.EMPTY;
        List<ServiceShuruiCodeEntity> サービス種類取得result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().計画依頼受付情報のサービス種類取得(被保険者番号);

        if (サービス種類取得result != null && !サービス種類取得result.isEmpty()) {
            for (ServiceShuruiCodeEntity serviceEntity : サービス種類取得result) {
                if (ServiceCategoryShurui.ケアマネ.getコード().equals(serviceEntity.getサービス種類().value())) {
                    サービス種類 = ケアマネジメント;
                } else if (ServiceCategoryShurui.居宅支援.getコード().equals(serviceEntity.getサービス種類().value())) {
                    サービス種類 = 居宅介護;
                } else if (ServiceCategoryShurui.予防支援.getコード().equals(serviceEntity.getサービス種類().value())) {
                    サービス種類 = 居宅予防;
                } else if (ServiceCategoryShurui.地小規単.getコード().equals(serviceEntity.getサービス種類().value())) {
                    サービス種類 = 小規模介護;
                } else if (ServiceCategoryShurui.地予小短.getコード().equals(serviceEntity.getサービス種類().value())) {
                    サービス種類 = 小規模予防;
                }
                if (!RString.EMPTY.equals(サービス種類)) {
                    サービス種類.concat(new RString("、"));
                }
            }
            if (!RString.EMPTY.equals(サービス種類)) {
                サービス種類.trimEnd();
            }
        }
        div.getDvKeikakuIraiUketsuke().getTxtServiceShurui().setValue(サービス種類);
    }

    private void selectFor自己作成(HihokenshaNo 被保険者番号) {
        List<DbT4001JukyushaDaichoEntity> dbt4001Result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().認定申請中状況の取得(被保険者番号);
        if (dbt4001Result == null || dbt4001Result.isEmpty()) {
            div.getDvJikoSakuseiKeikaku().getTxtJikoNinteiShinseiJokyo().setValue(RString.EMPTY);
        } else if (JukyuShinseiJiyu.初回申請.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvJikoSakuseiKeikaku().getTxtJikoNinteiShinseiJokyo().setValue(SHINKI_SHISEI);
        } else if (JukyuShinseiJiyu.再申請_有効期限内.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())
                || JukyuShinseiJiyu.再申請_有効期限外.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvJikoSakuseiKeikaku().getTxtJikoNinteiShinseiJokyo().setValue(SAI_SHISEI);
        } else if (JukyuShinseiJiyu.要介護度変更申請.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvJikoSakuseiKeikaku().getTxtJikoNinteiShinseiJokyo().setValue(HENKOU_SHISEI);
        } else if (JukyuShinseiJiyu.指定サービス種類変更申請.getコード().equals(dbt4001Result.get(0).getJukyuShinseiJiyu().getKey())) {
            div.getDvJikoSakuseiKeikaku().getTxtJikoNinteiShinseiJokyo().setValue(SERVICE_HENKOU);
        }

        List<JikoSakuseiKeikakuJohoEntity> 自己作成計画情報result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().自己作成計画情報の取得(被保険者番号);

        if (自己作成計画情報result != null && !自己作成計画情報result.isEmpty()) {
            div.getDvJikoSakuseiKeikaku().getTxtSetteiYM().setValue(
                    new RDate(自己作成計画情報result.get(0).get対象年月().getYearValue(), 自己作成計画情報result.get(0).get対象年月().getMonthValue()));
            div.getDvJikoSakuseiKeikaku().getTxtSakuseiDate().setValue(new RDate(
                    自己作成計画情報result.get(0).get計画作成年月日().getYearValue(),
                    自己作成計画情報result.get(0).get計画作成年月日().getMonthValue(),
                    自己作成計画情報result.get(0).get計画作成年月日().getDayValue()));
            div.getDvJikoSakuseiKeikaku().getTxtJikoShinseiDate().setValue(
                    自己作成計画情報result.get(0).get届出年月日());
            div.getDvJikoSakuseiKeikaku().getTxtJikoKeikakuTekiyoStartDate().setValue((new RDate(
                    自己作成計画情報result.get(0).get適用開始年月日().getYearValue(),
                    自己作成計画情報result.get(0).get適用開始年月日().getMonthValue(),
                    自己作成計画情報result.get(0).get適用開始年月日().getDayValue())));
            div.getDvJikoSakuseiKeikaku().getTxtJikoKeikakuTekiyoEndDate().setValue((new RDate(
                    自己作成計画情報result.get(0).get適用終了年月日().getYearValue(),
                    自己作成計画情報result.get(0).get適用終了年月日().getMonthValue(),
                    自己作成計画情報result.get(0).get適用終了年月日().getDayValue())));

            List<RString> keys = new ArrayList<>();
            if (ZanteiKubun.暫定.getコード().equals(自己作成計画情報result.get(0).get暫定区分())) {
                keys.add(new RString("0"));
            }
            div.getDvJikoSakuseiKeikaku().getChkZanteiKeikaku().setSelectedItemsByKey(keys);
        }

        List<DbV4001JukyushaDaichoEntity> dbV4001Result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().認定情報の取得(被保険者番号);
        if (dbV4001Result != null && !dbV4001Result.isEmpty()) {

            if (dbV4001Result.get(0).getNinteiYMD() == null || dbV4001Result.get(0).getNinteiYMD().isEmpty()) {
                div.getDvJikoSakuseiKeikaku().getTxtYokaigodo().setValue(RString.EMPTY);
            } else {
                div.getDvJikoSakuseiKeikaku().getTxtYokaigodo().setValue(YokaigoJotaiKubunSupport.
                        toValue(FlexibleDate.getNowDate(), dbV4001Result.get(0).getYokaigoJotaiKubunCode().getKey()).getName());
            }

            div.getDvJikoSakuseiKeikaku().getTxtNinteiYukokikan().
                    setFromValue(new RDate(dbV4001Result.get(0).getNinteiYukoKikanKaishiYMD().toString()));
            div.getDvJikoSakuseiKeikaku().getTxtNinteiYukokikan().
                    setToValue(new RDate(dbV4001Result.get(0).getNinteiYukoKikanShuryoYMD().toString()));
        }
    }

    private void 居宅サービス情報ボタン押下時(HihokenshaNo 被保険者番号) {
        List<DbT4001JukyushaDaichoEntity> dbt4001Result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().認定申請中状況の取得(被保険者番号);
        if (dbt4001Result != null && !dbt4001Result.isEmpty()) {

            div.getDvKyotakuService().getTxtShikyuGendoGaku().setValue(dbt4001Result.get(0).getShikyuGendoTanisu());
            FlexibleDate shikyuGendoKaishiYMD = dbt4001Result.get(0).getShikyuGendoKaishiYMD();
            if (shikyuGendoKaishiYMD != null) {
                div.getDvKyotakuService().getTxtGendoKanriKikan().
                        setFromValue(new RDate(shikyuGendoKaishiYMD.toString()));
            }
            FlexibleDate shikyuGendoShuryoYMD = dbt4001Result.get(0).getShikyuGendoShuryoYMD();
            if (shikyuGendoShuryoYMD != null) {
                div.getDvKyotakuService().getTxtGendoKanriKikan().
                        setToValue(new RDate(shikyuGendoShuryoYMD.toString()));
            }
        }

        List<DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity> dbt3010Result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().居宅サービス明細情報の短期入所利用日数取得(被保険者番号);

        if (dbt3010Result != null && !dbt3010Result.isEmpty()) {
            for (DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity : dbt3010Result) {
                Decimal zenkaiRiyoNissu = entity.getZenkaiRiyoNissu();
                Decimal konkaiKeikakuRiyoNissu = entity.getKonkaiKeikakuRiyoNissu();
                if (FlexibleDate.getNowDate().getYearMonth().equals(entity.getRiyoYM())
                        && zenkaiRiyoNissu != null
                        && konkaiKeikakuRiyoNissu != null) {
                    div.getDvKyotakuService().getTxtZengetsuMadeRiyoNissu().setValue(entity.getZenkaiRiyoNissu());
                    div.getDvKyotakuService().getTxtTogetsuKeikakuRiyoNissu().setValue(entity.getKonkaiKeikakuRiyoNissu());
                    div.getDvKyotakuService().getTxtRuisekiRiyoNissu().setValue(zenkaiRiyoNissu.add(konkaiKeikakuRiyoNissu));
                }
            }
        }

        List<KyotakuServiceMeisaiEntity> 居宅サービス明細情報Result
                = KyotakuServiceKeikakuIchiranFinder.createInstance().居宅サービス明細情報の取得(
                        被保険者番号,
                        div.getDgKyotakuServiceKeikakuIchiran().getClickedItem().getTaishoYM().getValue().getYearMonth(),
                        Integer.parseInt(div.getDgKyotakuServiceKeikakuIchiran().getClickedItem().getRirekiNo().toString()));
        if (居宅サービス明細情報Result != null && !居宅サービス明細情報Result.isEmpty()) {
            List<dgKyotakuService_Row> dgServiceList = new ArrayList<>();
            for (KyotakuServiceMeisaiEntity 居宅サービス明細情報Entity : 居宅サービス明細情報Result) {
                dgKyotakuService_Row row = new dgKyotakuService_Row();

                row.setJigyoshaNo(居宅サービス明細情報Entity.getサービス提供事業者番号().value());
                row.setServiceShuruiCode(居宅サービス明細情報Entity.getサービス種類コード().value());
                row.setServiceKomokuCode(居宅サービス明細情報Entity.getサービス項目コード().value());
                if (居宅サービス明細情報Entity.getサービス種類コード() != null && 居宅サービス明細情報Entity.getサービス項目コード().value() != null) {
                    row.setServiceCode(居宅サービス明細情報Entity.getサービス種類コード().value().
                            concat(居宅サービス明細情報Entity.getサービス項目コード().value()));
                }
                row.setServiceName(居宅サービス明細情報Entity.get事業者名称().value());

                row.setTani(new RString(居宅サービス明細情報Entity.get単位数().toString()));
                row.setWaribikigoRitsu(new RString(居宅サービス明細情報Entity.get割引後適用率().value().toString()));
                row.setWaribikigoTani(new RString(居宅サービス明細情報Entity.get割引後適用単位数().toString()));
                row.setKaisu(new RString(居宅サービス明細情報Entity.get回数_日数().toString()));
                if (居宅サービス明細情報Entity.get回数_日数() != null && 居宅サービス明細情報Entity.get割引後適用単位数() != null) {
                    row.setServiceTani(new RString(居宅サービス明細情報Entity.get回数_日数().
                            multiply(居宅サービス明細情報Entity.get割引後適用単位数()).toString()));
                }
                row.setShuruiGendoKijunChoka(new RString(居宅サービス明細情報Entity.get種類限度超過単位数().toString()));
                row.setShuruiGendoKijunNai(new RString(居宅サービス明細情報Entity.get種類限度内単位数().toString()));
                row.setKubunGendoKijunChoka(new RString(居宅サービス明細情報Entity.get区分限度超過単位数().toString()));
                row.setKubunGendoKijunNai(new RString(居宅サービス明細情報Entity.get区分限度内単位数().toString()));
                row.setTaniTanka(new RString(居宅サービス明細情報Entity.get単位数単価().toString()));

                Decimal 費用総額 = Decimal.ZERO;
                Decimal 保険給付額 = Decimal.ZERO;
                if (居宅サービス明細情報Entity.get区分限度内単位数() != null && 居宅サービス明細情報Entity.get単位数単価() != null) {
                    費用総額 = 居宅サービス明細情報Entity.get区分限度内単位数().multiply(居宅サービス明細情報Entity.get単位数単価());
                    row.setHiyoSogaku(new RString(費用総額.toString()));
                }
                row.setKyufuRitsu(new RString(居宅サービス明細情報Entity.get給付率().value().toString()));
                if (居宅サービス明細情報Entity.get区分限度内単位数() != null
                        && 居宅サービス明細情報Entity.get単位数単価() != null
                        && 居宅サービス明細情報Entity.get給付率() != null) {
                    保険給付額 = 居宅サービス明細情報Entity.get区分限度内単位数().
                            multiply(居宅サービス明細情報Entity.get単位数単価()).multiply(居宅サービス明細情報Entity.get給付率().value());

                    row.setHokenKyufuGaku(new RString(保険給付額.toString()));
                }

                row.setRiyoushaFutanTaishobun(new RString(費用総額.subtract(保険給付額).toString()));
                if (居宅サービス明細情報Entity.get種類限度超過単位数() != null
                        && 居宅サービス明細情報Entity.get区分限度超過単位数() != null
                        && 居宅サービス明細情報Entity.get単位数単価() != null) {
                    row.setRiyoushaFutanZengaku(new RString(居宅サービス明細情報Entity.get種類限度超過単位数().
                            add(居宅サービス明細情報Entity.get区分限度超過単位数()).multiply(居宅サービス明細情報Entity.get単位数単価()).toString()));
                }

                dgServiceList.add(row);
            }
            div.getDgKyotakuService().setDataSource(dgServiceList);
        }
    }

    private void 居宅サービス情報データグリッドを選択() {

        dgKyotakuService_Row serviceRow = div.getDgKyotakuService().getActiveRow();
        div.getDvKyotakuMeisai().getTxtKyotakuJigyoshaNo().setValue(serviceRow.getJigyoshaNo());
        div.getDvKyotakuMeisai().getTxtKyotakuJigyoshaName().setValue(serviceRow.getServiceName());
        div.getDvKyotakuMeisai().getTxtServiceCode1().setValue(serviceRow.getServiceShuruiCode());
        div.getDvKyotakuMeisai().getTxtServiceCode2().setValue(serviceRow.getServiceKomokuCode());
        div.getDvKyotakuMeisai().getTxtServiceName().setValue(serviceRow.getServiceName());
        div.getDvKyotakuMeisai().getTxtTani().setValue(new Decimal(serviceRow.getTani().toString()));
        div.getDvKyotakuMeisai().getTxtWaribikiTekiyogoRitsu().setValue(new Decimal(serviceRow.getWaribikigoRitsu().toString()));
        div.getDvKyotakuMeisai().getTxtWaribikiTekiyogoTani().setValue(new Decimal(serviceRow.getWaribikigoTani().toString()));
        div.getDvKyotakuMeisai().getTxtKaisu().setValue(new Decimal(serviceRow.getKaisu().toString()));
        div.getDvKyotakuMeisai().getTxtServiceTani().setValue(new Decimal(serviceRow.getServiceTani().toString()));
        div.getDvKyotakuMeisai().getTxtShuruiGendoChokaTani().
                setValue(new Decimal(serviceRow.getShuruiGendoKijunChoka().toString()));
        div.getDvKyotakuMeisai().getTxtShuruiGendonaiTani().setValue(new Decimal(serviceRow.getShuruiGendoKijunNai().toString()));
        div.getDvKyotakuMeisai().getTxtTaniTanka().setValue(new Decimal(serviceRow.getTaniTanka().toString()));
        div.getDvKyotakuMeisai().getTxtKubunGendoChokaTani().
                setValue(new Decimal(serviceRow.getKubunGendoKijunChoka().toString()));
        div.getDvKyotakuMeisai().getTxtKubunGendonaiTani().setValue(new Decimal(serviceRow.getKubunGendoKijunNai().toString()));
        div.getDvKyotakuMeisai().getTxtKyufuRitsu().setValue(new Decimal(serviceRow.getKyufuRitsu().toString()));
        div.getDvKyotakuMeisai().getTxtHiyoSogaku().setValue(new Decimal(serviceRow.getHiyoSogaku().toString()));
        div.getDvKyotakuMeisai().getTxtHokenKyufuGaku().setValue(new Decimal(serviceRow.getHokenKyufuGaku().toString()));
        div.getDvKyotakuMeisai().getTxtHokenTaishoRiyoshaFutanGaku().
                setValue(new Decimal(serviceRow.getRiyoushaFutanTaishobun().toString()));
        div.getDvKyotakuMeisai().getTxtZengakuRiyoshaFutanngaku().
                setValue(new Decimal(serviceRow.getRiyoushaFutanZengaku().toString()));
    }

    private void 種類限度額確認ボタン押下時() {

        List<ShuruiGendoKakuEntity> resultList
                = KyotakuServiceKeikakuIchiranFinder.createInstance().種類限度額一覧の取得(
                        new HihokenshaNo(div.getHiddenHihokenshaNo()),
                        div.getDgKyotakuServiceKeikakuIchiran().getClickedItem().getTaishoYM().getValue().getYearMonth(),
                        Integer.parseInt(div.getDgKyotakuServiceKeikakuIchiran().getClickedItem().getRirekiNo().toString()));

        if (resultList != null && !resultList.isEmpty()) {
            List<dgShuruiGendoKakunin_Row> dgList = new ArrayList<>();
            for (ShuruiGendoKakuEntity entity : resultList) {
                dgShuruiGendoKakunin_Row row = new dgShuruiGendoKakunin_Row();

                if (entity.getサービス種類() != null) {
                    row.setServiceShurui(ServiceCategoryShurui.toValue(entity.getサービス種類().value()).get名称());
                }
                TextBoxNum 限度額 = new TextBoxNum();
                限度額.setValue(entity.get支給限度単位数());
                row.setGendoGaku(限度額);

                TextBoxNum 合計単位数 = new TextBoxNum();
                合計単位数.setValue(entity.get種類限度内単位数());
                row.setGokeiTansu(合計単位数);

                if (entity.get限度超過単位数().intValue() >= 0) {
                    TextBoxNum 限度超過単位数 = new TextBoxNum();
                    限度超過単位数.setValue(entity.get限度超過単位数());
                    row.setGendoChokaTanisu(限度超過単位数);
                }

                dgList.add(row);
            }
            div.getDgShuruiGendoKakunin().setDataSource(dgList);
        }
    }

    private void 状態１() {
        div.getDgKyotakuServiceKeikakuIchiranMain().setDisplayNone(false);
        div.getDvJohoSelect().setDisplayNone(true);
        div.getDvKeikakuIraiUketsuke().setDisplayNone(true);
        div.getDvJikoSakuseiKeikaku().setDisplayNone(true);
        div.getDvKyotakuService().setDisplayNone(true);
        div.getDvKyotakuMeisai().setDisplayNone(true);
        div.getDvShuruiGendoKakunin().setDisplayNone(true);
    }

    private void 状態２() {
        div.getBtnKeikakuIraiUketsuke().setDisabled(false);
        div.getBtnJikosakuseiKeikaku().setDisabled(true);
        div.getBtnKyotakuService().setDisabled(true);

        div.getDgKyotakuServiceKeikakuIchiranMain().setDisplayNone(true);
        div.getDvJohoSelect().setDisplayNone(false);
        div.getDvKeikakuIraiUketsuke().setDisplayNone(false);
        div.getDvJikoSakuseiKeikaku().setDisplayNone(true);
        div.getDvKyotakuService().setDisplayNone(true);
        div.getDvKyotakuMeisai().setDisplayNone(true);
        div.getDvShuruiGendoKakunin().setDisplayNone(true);
    }

    private void 状態３() {
        div.getBtnKeikakuIraiUketsuke().setDisabled(true);
        div.getBtnJikosakuseiKeikaku().setDisabled(false);
        div.getBtnKyotakuService().setDisabled(false);

        div.getDgKyotakuServiceKeikakuIchiranMain().setDisplayNone(true);
        div.getDvJohoSelect().setDisplayNone(false);
        div.getDvKeikakuIraiUketsuke().setDisplayNone(true);
        div.getDvJikoSakuseiKeikaku().setDisplayNone(false);
        div.getDvKyotakuService().setDisplayNone(true);
        div.getDvKyotakuMeisai().setDisplayNone(true);
        div.getDvShuruiGendoKakunin().setDisplayNone(true);
    }

    private void 状態４() {
        div.getBtnKeikakuIraiUketsuke().setDisabled(true);
        div.getBtnJikosakuseiKeikaku().setDisabled(false);
        div.getBtnKyotakuService().setDisabled(false);

        div.getDgKyotakuServiceKeikakuIchiranMain().setDisplayNone(true);
        div.getDvJohoSelect().setDisplayNone(false);
        div.getDvKeikakuIraiUketsuke().setDisplayNone(true);
        div.getDvJikoSakuseiKeikaku().setDisplayNone(true);
        div.getDvKyotakuService().setDisplayNone(false);
        div.getDvKyotakuMeisai().setDisplayNone(true);
        div.getDvShuruiGendoKakunin().setDisplayNone(true);
    }

    private void 状態５() {
        div.getDgKyotakuServiceKeikakuIchiranMain().setDisplayNone(true);
        div.getDvJohoSelect().setDisplayNone(true);
        div.getDvKeikakuIraiUketsuke().setDisplayNone(true);
        div.getDvJikoSakuseiKeikaku().setDisplayNone(true);
        div.getDvKyotakuService().setDisplayNone(true);
        div.getDvKyotakuMeisai().setDisplayNone(false);
        div.getDvShuruiGendoKakunin().setDisplayNone(true);
    }

    private void 状態６() {
        div.getDgKyotakuServiceKeikakuIchiranMain().setDisplayNone(true);
        div.getDvJohoSelect().setDisplayNone(true);
        div.getDvKeikakuIraiUketsuke().setDisplayNone(true);
        div.getDvJikoSakuseiKeikaku().setDisplayNone(true);
        div.getDvKyotakuService().setDisplayNone(true);
        div.getDvKyotakuMeisai().setDisplayNone(true);
        div.getDvShuruiGendoKakunin().setDisplayNone(false);
    }
}
