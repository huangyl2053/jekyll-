package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.JigyoshaNyuryokuGudieCommonChildDiv;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.GunshiCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.JigyoshaMode;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.KenCodeJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.ServiceJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.business.core.jigyosha.ServiceShuruiJigyoshaInputGuide;
import jp.co.ndensan.reams.db.dba.definition.jigyosha.JigyoshaInputGuideParameter;
import jp.co.ndensan.reams.db.dba.service.core.jigyosha.JigyoshaInputGuideFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyoshaKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 事業者・施設選択入力ガイドDivのHandlerクラスです。
 */
public class JiGyoSyaHandler {

    private final JigyoshaNyuryokuGudieCommonChildDivDiv div;
    private final Decimal 最大表示件数_100 = new Decimal(100);

    /**
     * コンストラクタです。
     *
     * @param div 事業者種類共有子Divのエンティティ
     */
    public JiGyoSyaHandler(JigyoshaNyuryokuGudieCommonChildDivDiv div) {
        this.div = div;
    }

    /**
     * 県コードと郡市コードの連動。
     *
     * @param mode JigyoshaMode
     */
    public void search_GunshiCode(JigyoshaMode mode) {

        List<GunshiCodeJigyoshaInputGuide> gunshiCodeJigyoshaInputGuide = mode.getGunshiCodeJigyoshaInputGuide();
        List<KeyValueDataSource> dataSource = new ArrayList();
        if (gunshiCodeJigyoshaInputGuide != null) {

            for (GunshiCodeJigyoshaInputGuide entity : gunshiCodeJigyoshaInputGuide) {

                if (entity.get都道府県コード().equals(div.getTaishoJigyoshaKensaku().getDdlKennCode().getSelectedKey())) {

                    KeyValueDataSource KeyValue = new KeyValueDataSource();

                    KeyValue.setKey(entity.get郡市区コード());
                    KeyValue.setValue(entity.get郡市区名称());
                    dataSource.add(KeyValue);
                }
            }
        }
        div.getTaishoJigyoshaKensaku().getDdlGunshiCode().setDataSource(dataSource);
    }

    /**
     * 対象事業者を検索する。
     *
     * @param mode JigyoshaMode
     */
    public void search_Jigyosya(JigyoshaMode mode) {

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.介護保険施設.toRString())) {

            SearchResult<ServiceJigyoshaInputGuide> Jigyosha = JigyoshaInputGuideFinder.createInstance().getServiceJigyoshaInputGuide(
                    JigyoshaInputGuideParameter.createParam_ServiceJigyoshaInputGuide(new KaigoJigyoshaNo(
                                    div.getKennsakuJyokenn().getTxtJIgyoshaNo().getValue()),
                            div.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue() == null ? FlexibleDate.EMPTY
                            : new FlexibleDate(div.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue().toString()),
                            div.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue() == null ? FlexibleDate.EMPTY
                            : new FlexibleDate(div.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue().toString()),
                            new AtenaMeisho(div.getKennsakuJyokenn().getTxtJigyoshamei().getValue()),
                            new YubinNo(div.getKennsakuJyokenn().getTxtYubinNo().getValue().toString()),
                            div.getKennsakuJyokenn().getTxtJusho().getDomain().value(),
                            div.getKennsakuJyokenn().getServiceJigyosha().getDdlServiceShurui().getSelectedKey(),
                            div.getKennsakuJyokenn().getServiceJigyosha().getDdlJigyoshaKubun().getSelectedKey(),
                            div.getKennsakuJyokenn().getDdlKennsakuKubun().getSelectedKey(),
                            div.getKennsakuJyokenn().getServiceJigyosha().getDdlGunshiCode().getSelectedKey(),
                            FlexibleDate.getNowDate(),
                            div.getKennsakuJyokenn().getServiceJigyosha().getDdlKennCode().getSelectedKey(),
                            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue() == null ? 0
                            : div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue()));

            List<dgJigyoshaItiran_Row> dgJigyoshaItiranList = new ArrayList();
            if (!Jigyosha.records().isEmpty()) {

                for (ServiceJigyoshaInputGuide jigyoshaInput : Jigyosha.records()) {

                    dgJigyoshaItiran_Row dgJigyoshaItiran = new dgJigyoshaItiran_Row();
                    dgJigyoshaItiran.setTxtJigyoshaNo(jigyoshaInput.get事業者番号().value());
                    dgJigyoshaItiran.getTxtYukoKaishibiYMD().setValue(new RDate(jigyoshaInput.get有効開始日().toString()));
                    dgJigyoshaItiran.getTxtYukoShuryobiYMD().setValue(new RDate(jigyoshaInput.get有効終了日().toString()));
                    dgJigyoshaItiran.setTxtMeisho(jigyoshaInput.get事業者名称() == null ? RString.EMPTY : jigyoshaInput.get事業者名称().value());
                    dgJigyoshaItiran.setTxtServiceShurui(jigyoshaInput.getサービス種類略称());
                    dgJigyoshaItiran.setTxtJusho(jigyoshaInput.get事業者住所カナ());
                    dgJigyoshaItiran.setTxtTelNo(jigyoshaInput.get電話番号() == null ? RString.EMPTY : jigyoshaInput.get電話番号().value());
                    dgJigyoshaItiranList.add(dgJigyoshaItiran);
                }
                div.getJigyoshaItirann().getDgJigyoshaItiran().setDataSource(dgJigyoshaItiranList);
            } else {

                div.getJigyoshaItirann().getDgJigyoshaItiran().setDataSource(dgJigyoshaItiranList);
            }
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.住所地特例対象施設.toRString())) {

            SearchResult<ServiceJigyoshaInputGuide> Jigyosha = JigyoshaInputGuideFinder.createInstance().getOtherTokureiInputGuide(
                    JigyoshaInputGuideParameter.createParam_OtherTokureiInputGuide(new KaigoJigyoshaNo(
                                    div.getKennsakuJyokenn().getTxtJIgyoshaNo().getValue()),
                            div.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue() == null ? FlexibleDate.EMPTY
                            : new FlexibleDate(div.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue().toString()),
                            div.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue() == null ? FlexibleDate.EMPTY
                            : new FlexibleDate(div.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue().toString()),
                            new AtenaMeisho(div.getKennsakuJyokenn().getTxtJigyoshamei().getValue()),
                            new YubinNo(div.getKennsakuJyokenn().getTxtYubinNo().getValue().toString()),
                            div.getKennsakuJyokenn().getTxtJusho().getDomain().value(),
                            div.getKennsakuJyokenn().getDdlKennsakuKubun().getSelectedKey(),
                            FlexibleDate.getNowDate(),
                            div.getOtherTokureiShisetsu().getRadKannaiKanngaiKubun().getSelectedKey(),
                            ShisetsuType.住所地特例対象施設.code(),
                            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue() == null ? 0
                            : div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue()));

            List<dgJigyoshaItiran_Row> dgJigyoshaItiranList = new ArrayList();

            if (Jigyosha.totalCount() != 0) {

                for (ServiceJigyoshaInputGuide jigyoshaInput : Jigyosha.records()) {

                    dgJigyoshaItiran_Row dgJigyoshaItiran = new dgJigyoshaItiran_Row();
                    dgJigyoshaItiran.setTxtJigyoshaNo(jigyoshaInput.get事業者番号().value());
                    dgJigyoshaItiran.getTxtYukoKaishibiYMD().setValue(new RDate(jigyoshaInput.get有効開始日().toString()));
                    dgJigyoshaItiran.getTxtYukoShuryobiYMD().setValue(new RDate(jigyoshaInput.get有効終了日().toString()));
                    dgJigyoshaItiran.setTxtMeisho(jigyoshaInput.get介護除外住所地特例対象施設_事業者名称カナ() == null ? RString.EMPTY : jigyoshaInput.get介護除外住所地特例対象施設_事業者名称カナ().value());
                    dgJigyoshaItiran.setTxtJusho(jigyoshaInput.get介護除外住所地特例対象施設_事業者住所カナ());
                    dgJigyoshaItiran.setTxtTelNo(jigyoshaInput.get電話番号() == null ? RString.EMPTY : jigyoshaInput.get電話番号().value());
                    dgJigyoshaItiranList.add(dgJigyoshaItiran);
                }
                div.getJigyoshaItirann().getDgJigyoshaItiran().setDataSource(dgJigyoshaItiranList);
            } else {

                div.getJigyoshaItirann().getDgJigyoshaItiran().setDataSource(dgJigyoshaItiranList);
            }
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.適用除外施設.toRString())) {

            SearchResult<ServiceJigyoshaInputGuide> Jigyosha = JigyoshaInputGuideFinder.createInstance().getTekiyoJogaiInputGuide(
                    JigyoshaInputGuideParameter.createParam_TekiyoJogaiInputGuide(new KaigoJigyoshaNo(
                                    div.getKennsakuJyokenn().getTxtJIgyoshaNo().getValue()),
                            div.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue() == null ? FlexibleDate.EMPTY
                            : new FlexibleDate(div.getKennsakuJyokenn().getTxtYukouKaishibi().getFromValue().toString()),
                            div.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue() == null ? FlexibleDate.EMPTY
                            : new FlexibleDate(div.getKennsakuJyokenn().getTxtYukouKaishibi().getToValue().toString()),
                            new AtenaMeisho(div.getKennsakuJyokenn().getTxtJigyoshamei().getValue()),
                            new YubinNo(div.getKennsakuJyokenn().getTxtYubinNo().getValue().toString()),
                            div.getKennsakuJyokenn().getTxtJusho().getDomain().value(),
                            div.getKennsakuJyokenn().getDdlKennsakuKubun().getSelectedKey(),
                            FlexibleDate.getNowDate(),
                            ShisetsuType.適用除外施設.code(),
                            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue() == null ? 0
                            : div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue()));
            List<dgJigyoshaItiran_Row> dgJigyoshaItiranList = new ArrayList();

            if (!Jigyosha.records().isEmpty()) {

                for (ServiceJigyoshaInputGuide jigyoshaInput : Jigyosha.records()) {

                    dgJigyoshaItiran_Row dgJigyoshaItiran = new dgJigyoshaItiran_Row();
                    dgJigyoshaItiran.setTxtJigyoshaNo(jigyoshaInput.get事業者番号().value());
                    dgJigyoshaItiran.getTxtYukoKaishibiYMD().setValue(new RDate(jigyoshaInput.get有効開始日().toString()));
                    dgJigyoshaItiran.getTxtYukoShuryobiYMD().setValue(new RDate(jigyoshaInput.get有効終了日().toString()));
                    dgJigyoshaItiran.setTxtMeisho(jigyoshaInput.get介護除外住所地特例対象施設_事業者名称カナ() == null ? RString.EMPTY : jigyoshaInput.get介護除外住所地特例対象施設_事業者名称カナ().value());
                    dgJigyoshaItiran.setTxtJusho(jigyoshaInput.get介護除外住所地特例対象施設_事業者住所カナ());
                    dgJigyoshaItiran.setTxtTelNo(jigyoshaInput.get電話番号() == null ? RString.EMPTY : jigyoshaInput.get電話番号().value());
                    dgJigyoshaItiranList.add(dgJigyoshaItiran);
                }
                div.getJigyoshaItirann().getDgJigyoshaItiran().setDataSource(dgJigyoshaItiranList);
            } else {

                div.getJigyoshaItirann().getDgJigyoshaItiran().setDataSource(dgJigyoshaItiranList);
            }
        }
    }

    /**
     * 引数の事業者種類を検索して設定します。
     *
     * @param mode JigyoshaMode
     */
    public void load(JigyoshaMode mode) {

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.介護保険施設.toRString())) {

            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(true);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(最大表示件数_100);
            div.getTaishoJigyoshaKensaku().getDdlKennCode().setDataSource(get県コード());
            div.getTaishoJigyoshaKensaku().getDdlGunshiCode().setDataSource(get郡市コード(mode));
            div.getTaishoJigyoshaKensaku().getDdlServiceShurui().setDataSource(getサービス種類());
            div.getTaishoJigyoshaKensaku().getDdlJigyoshaKubun().setDataSource(get事業者区分());
            div.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun().setDataSource(get検索条件区分());
            div.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun().setSelectedKey(new RString("key0"));
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(true);
            div.getOtherTokureiShisetsu().setVisible(false);
            Association association = finder.getAssociation();
            div.getTaishoJigyoshaKensaku().getDdlKennCode().setSelectedKey(association.get地方公共団体コード() == null ? RString.EMPTY : association.get地方公共団体コード().value().substring(0, 2));
            search_GunshiCode(mode);
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.住所地特例対象施設.toRString())) {

            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(false);
            div.getOtherTokureiShisetsu().getRadKannaiKanngaiKubun().setSelectedKey(new RString("0"));
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(最大表示件数_100);
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(false);
            div.getOtherTokureiShisetsu().setVisible(true);
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.適用除外施設.toRString())) {

            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(false);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(最大表示件数_100);
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(false);
            div.getOtherTokureiShisetsu().setVisible(false);
        }
    }

    private List<KeyValueDataSource> get県コード() {

        JigyoshaInputGuideFinder jigyosha = new JigyoshaInputGuideFinder();
        List<KeyValueDataSource> dataSource = new ArrayList();
        SearchResult<KenCodeJigyoshaInputGuide> kenCodeJigyoshaInputGuide = jigyosha.getKenCodeJigyoshaInputGuide();

        if (!kenCodeJigyoshaInputGuide.records().isEmpty()) {

            for (KenCodeJigyoshaInputGuide entity : kenCodeJigyoshaInputGuide.records()) {

                KeyValueDataSource KeyValue = new KeyValueDataSource();
                KeyValue.setKey(entity.get都道府県住所コード());
                KeyValue.setValue(entity.get都道府県住所コード().concat(new RString(":")).concat(entity.get都道府県名()));

                dataSource.add(KeyValue);
            }
        }
        return dataSource;
    }

    private List<KeyValueDataSource> get事業者区分() {

        List<KeyValueDataSource> dataSource = new ArrayList();

        KeyValueDataSource KeyValue1 = new KeyValueDataSource();
        KeyValueDataSource KeyValue3 = new KeyValueDataSource();
        KeyValueDataSource KeyValue4 = new KeyValueDataSource();
        KeyValueDataSource KeyValue5 = new KeyValueDataSource();
        KeyValueDataSource KeyValue6 = new KeyValueDataSource();
        KeyValueDataSource KeyValue7 = new KeyValueDataSource();
        KeyValueDataSource KeyValue8 = new KeyValueDataSource();

        KeyValue1.setKey(JigyoshaKubun.医科.getコード());
        KeyValue3.setKey(JigyoshaKubun.歯科.getコード());
        KeyValue4.setKey(JigyoshaKubun.薬局.getコード());
        KeyValue5.setKey(JigyoshaKubun.老人保健施設.getコード());
        KeyValue6.setKey(JigyoshaKubun.訪問看護ステーション.getコード());
        KeyValue7.setKey(JigyoshaKubun.介護保険事業所.getコード());
        KeyValue8.setKey(JigyoshaKubun.基準該当事業所.getコード());
        KeyValue1.setValue(JigyoshaKubun.医科.get名称());
        KeyValue3.setValue(JigyoshaKubun.歯科.get名称());
        KeyValue4.setValue(JigyoshaKubun.薬局.get名称());
        KeyValue5.setValue(JigyoshaKubun.老人保健施設.get名称());
        KeyValue6.setValue(JigyoshaKubun.訪問看護ステーション.get名称());
        KeyValue7.setValue(JigyoshaKubun.介護保険事業所.get名称());
        KeyValue8.setValue(JigyoshaKubun.基準該当事業所.get名称());

        dataSource.add(KeyValue1);
        dataSource.add(KeyValue3);
        dataSource.add(KeyValue4);
        dataSource.add(KeyValue5);
        dataSource.add(KeyValue6);
        dataSource.add(KeyValue7);
        dataSource.add(KeyValue8);
        return dataSource;
    }

    private List<KeyValueDataSource> get検索条件区分() {

        List<KeyValueDataSource> dataSource = new ArrayList();

        KeyValueDataSource KeyValue1 = new KeyValueDataSource();
        KeyValueDataSource KeyValue2 = new KeyValueDataSource();
        KeyValue1.setKey(new RString("key0"));
        KeyValue2.setKey(new RString("key1"));
        KeyValue1.setValue(new RString("前方一致"));
        KeyValue2.setValue(new RString("完全一致"));

        dataSource.add(KeyValue1);
        dataSource.add(KeyValue2);
        return dataSource;
    }

    private List<KeyValueDataSource> get郡市コード(JigyoshaMode mode) {

        JigyoshaInputGuideFinder jigyosha = new JigyoshaInputGuideFinder();
        List<KeyValueDataSource> dataSource = new ArrayList();
        SearchResult<GunshiCodeJigyoshaInputGuide> gunshiCodeJigyoshaInputGuide = jigyosha.getGunshiCodeJigyoshaInputGuide();

        mode.setGunshiCodeJigyoshaInputGuide(gunshiCodeJigyoshaInputGuide.records());
        div.setJigyoshaMode(DataPassingConverter.serialize(mode));

        if (!gunshiCodeJigyoshaInputGuide.records().isEmpty()) {

            for (GunshiCodeJigyoshaInputGuide entity : gunshiCodeJigyoshaInputGuide.records()) {

                KeyValueDataSource KeyValue = new KeyValueDataSource();
                KeyValue.setKey(entity.get郡市区コード());
                KeyValue.setValue(entity.get郡市区名称());

                dataSource.add(KeyValue);
            }
        }

        return dataSource;
    }

    private List<KeyValueDataSource> getサービス種類() {

        JigyoshaInputGuideFinder jigyosha = new JigyoshaInputGuideFinder();
        List<KeyValueDataSource> dataSource = new ArrayList();
        SearchResult<ServiceShuruiJigyoshaInputGuide> serviceShuruiJigyoshaInputGuide = jigyosha.getServiceShuruiJigyoshaInputGuidea(RDate.getNowDate().getYearMonth());

        if (!serviceShuruiJigyoshaInputGuide.records().isEmpty()) {

            for (ServiceShuruiJigyoshaInputGuide entity : serviceShuruiJigyoshaInputGuide.records()) {

                KeyValueDataSource KeyValue = new KeyValueDataSource();
                KeyValue.setKey(entity.getサービス種類コード().value());
                KeyValue.setValue(entity.getサービス種類略称());

                dataSource.add(KeyValue);
            }
        }
        return dataSource;
    }
}
