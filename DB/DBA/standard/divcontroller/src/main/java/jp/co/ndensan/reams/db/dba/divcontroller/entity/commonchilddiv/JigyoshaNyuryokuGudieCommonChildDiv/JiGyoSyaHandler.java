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
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbz.definition.core.jigyoshashubetsu.JigyosyaType;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.kaigojigyoshano.KaigoJigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.JigyoshaKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridSetting;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 事業者・施設選択入力ガイドDivのHandlerクラスです。
 */
public class JiGyoSyaHandler {

    private final JigyoshaNyuryokuGudieCommonChildDivDiv div;
    private final RString 前方一致 = new RString("前方一致");
    private final RString 完全一致 = new RString("完全一致");
    private final RString 前方一致_コード = new RString("key0");
    private final RString 完全一致_コード = new RString("key1");
    private final RString 管内管外区分_全て = new RString("0");

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
                DataGridSetting dataGrid = new DataGridSetting();
                dataGrid.setLimitRowCount(div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue());
                dataGrid.setSelectedRowCount(Jigyosha.totalCount());
                div.getJigyoshaItirann().getDgJigyoshaItiran().setGridSetting(dataGrid);
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
                            JigyosyaType.住所地特例対象施設.getコード(),
                            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue() == null ? 0
                            : div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue()));

            List<dgJigyoshaItiran_Row> dgJigyoshaItiranList = new ArrayList();

            if (Jigyosha.totalCount() != 0) {

                for (ServiceJigyoshaInputGuide jigyoshaInput : Jigyosha.records()) {

                    dgJigyoshaItiran_Row dgJigyoshaItiran = new dgJigyoshaItiran_Row();
                    dgJigyoshaItiran.setTxtJigyoshaNo(jigyoshaInput.get事業者番号().value());
                    dgJigyoshaItiran.getTxtYukoKaishibiYMD().setValue(new RDate(jigyoshaInput.get有効開始日().toString()));
                    dgJigyoshaItiran.getTxtYukoShuryobiYMD().setValue(new RDate(jigyoshaInput.get有効終了日().toString()));
                    dgJigyoshaItiran.setTxtMeisho(jigyoshaInput.get介護除外住所地特例対象施設_事業者名称カナ() == null
                            ? RString.EMPTY : jigyoshaInput.get介護除外住所地特例対象施設_事業者名称カナ().value());
                    dgJigyoshaItiran.setTxtJusho(jigyoshaInput.get介護除外住所地特例対象施設_事業者住所カナ());
                    dgJigyoshaItiran.setTxtTelNo(jigyoshaInput.get電話番号() == null ? RString.EMPTY : jigyoshaInput.get電話番号().value());
                    dgJigyoshaItiranList.add(dgJigyoshaItiran);
                }
                DataGridSetting dataGrid = new DataGridSetting();
                dataGrid.setLimitRowCount(div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue());
                dataGrid.setSelectedRowCount(Jigyosha.totalCount());
                div.getJigyoshaItirann().getDgJigyoshaItiran().setGridSetting(dataGrid);
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
                            JigyosyaType.適用除外施設.getコード(),
                            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue() == null ? 0
                            : div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue()));
            List<dgJigyoshaItiran_Row> dgJigyoshaItiranList = new ArrayList();

            if (!Jigyosha.records().isEmpty()) {
                int size = div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue() > Jigyosha.records().size() ?
                        Jigyosha.records().size() : div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue();
                for (int i =0 ;i < size; i++) {

                    dgJigyoshaItiran_Row dgJigyoshaItiran = new dgJigyoshaItiran_Row();
                    dgJigyoshaItiran.setTxtJigyoshaNo(Jigyosha.records().get(i).get事業者番号().value());
                    dgJigyoshaItiran.getTxtYukoKaishibiYMD().setValue(new RDate(Jigyosha.records().get(i).get有効開始日().toString()));
                    dgJigyoshaItiran.getTxtYukoShuryobiYMD().setValue(new RDate(Jigyosha.records().get(i).get有効終了日().toString()));
                    dgJigyoshaItiran.setTxtMeisho(Jigyosha.records().get(i).get介護除外住所地特例対象施設_事業者名称カナ() == null
                            ? RString.EMPTY : Jigyosha.records().get(i).get介護除外住所地特例対象施設_事業者名称カナ().value());
                    dgJigyoshaItiran.setTxtJusho(Jigyosha.records().get(i).get介護除外住所地特例対象施設_事業者住所カナ());
                    dgJigyoshaItiran.setTxtTelNo(Jigyosha.records().get(i).get電話番号() == null ? RString.EMPTY : Jigyosha.records().get(i).get電話番号().value());
                    dgJigyoshaItiranList.add(dgJigyoshaItiran);
                }
                DataGridSetting dataGrid = div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting();
                dataGrid.setLimitRowCount(div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().getValue().intValue());
                dataGrid.setSelectedRowCount(Jigyosha.totalCount());
                div.getJigyoshaItirann().getDgJigyoshaItiran().setGridSetting(dataGrid);
                
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
    public void initialize(JigyoshaMode mode) {

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.介護保険施設.toRString())) {

            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(true);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(new Decimal(BusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
            div.getTaishoJigyoshaKensaku().getDdlKennCode().setDataSource(get県コード());
            div.getTaishoJigyoshaKensaku().getDdlGunshiCode().setDataSource(get郡市コード(mode));
            div.getTaishoJigyoshaKensaku().getDdlServiceShurui().setDataSource(getサービス種類());
            div.getTaishoJigyoshaKensaku().getDdlJigyoshaKubun().setDataSource(get事業者区分());
            div.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun().setDataSource(get検索条件区分());
            div.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun().setSelectedKey(前方一致_コード);
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(true);
            div.getOtherTokureiShisetsu().setVisible(false);
            Association association = finder.getAssociation();
            div.getTaishoJigyoshaKensaku().getDdlKennCode().setSelectedKey(association.get地方公共団体コード() == null
                    ? RString.EMPTY : association.get地方公共団体コード().value().substring(0, 2));
            search_GunshiCode(mode);
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.住所地特例対象施設.toRString())) {

            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(false);
            div.getOtherTokureiShisetsu().getRadKannaiKanngaiKubun().setSelectedKey(管内管外区分_全て);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(new Decimal(BusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(false);
            div.getOtherTokureiShisetsu().setVisible(true);
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.適用除外施設.toRString())) {

            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(false);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(new Decimal(BusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(false);
            div.getOtherTokureiShisetsu().setVisible(false);
        }
    }

    /**
     * クリアボタンを実行します。
     *
     * @param mode JigyoshaMode
     */
    public void clear(JigyoshaMode mode) {

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.介護保険施設.toRString())) {

            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(true);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(new Decimal(BusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
            div.getKennsakuJyokenn().getTxtJIgyoshaNo().clearValue();
            div.getKennsakuJyokenn().getTxtYukouKaishibi().clearFromValue();
            div.getKennsakuJyokenn().getTxtYukouKaishibi().clearToValue();
            div.getKennsakuJyokenn().getTxtJigyoshamei().clearValue();
            div.getKennsakuJyokenn().getTxtYubinNo().clearValue();
            div.getKennsakuJyokenn().getTxtJusho().clearDomain();
            div.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun().setSelectedKey(前方一致_コード);
            div.getTaishoJigyoshaKensaku().getDdlGunshiCode().setSelectedKey(RString.EMPTY);
            div.getTaishoJigyoshaKensaku().getDdlServiceShurui().setSelectedKey(RString.EMPTY);
            div.getTaishoJigyoshaKensaku().getDdlJigyoshaKubun().setSelectedKey(RString.EMPTY);
            div.getJigyoshaItirann().getDgJigyoshaItiran().getDataSource().clear();
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(true);
            div.getOtherTokureiShisetsu().setVisible(false);
            Association association = finder.getAssociation();
            div.getTaishoJigyoshaKensaku().getDdlKennCode().setSelectedKey(association.get地方公共団体コード() == null
                    ? RString.EMPTY : association.get地方公共団体コード().value().substring(0, 2));
            search_GunshiCode(mode);
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.住所地特例対象施設.toRString())) {

            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(false);
            div.getOtherTokureiShisetsu().getRadKannaiKanngaiKubun().setSelectedKey(管内管外区分_全て);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(new Decimal(BusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
            div.getKennsakuJyokenn().getTxtJIgyoshaNo().clearValue();
            div.getKennsakuJyokenn().getTxtYukouKaishibi().clearFromValue();
            div.getKennsakuJyokenn().getTxtYukouKaishibi().clearToValue();
            div.getKennsakuJyokenn().getTxtJigyoshamei().clearValue();
            div.getKennsakuJyokenn().getTxtYubinNo().clearValue();
            div.getKennsakuJyokenn().getTxtJusho().clearDomain();
            div.getJigyoshaItirann().getDgJigyoshaItiran().getDataSource().clear();
            div.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun().setSelectedKey(前方一致_コード);
            div.getKennsakuJyokenn().setVisible(true);
            div.getKennsakuJyokenn().getServiceJigyosha().setVisible(false);
            div.getOtherTokureiShisetsu().setVisible(true);
        }

        if (ShisetsuType.toValue(mode.getJigyoshaShubetsu()).toRString().equals(ShisetsuType.適用除外施設.toRString())) {

            div.getJigyoshaItirann().getDgJigyoshaItiran().getGridSetting().getColumns().get(4).setVisible(false);
            div.getTaishoJigyoshaKensaku().getTxtMaxHyojiKensu().setValue(new Decimal(BusinessConfig.
                    get(ConfigNameDBU.検索制御_最大取得件数上限, SubGyomuCode.DBU介護統計報告).toString()));
            div.getKennsakuJyokenn().getTxtJIgyoshaNo().clearValue();
            div.getKennsakuJyokenn().getTxtYukouKaishibi().clearFromValue();
            div.getKennsakuJyokenn().getTxtYukouKaishibi().clearToValue();
            div.getKennsakuJyokenn().getTxtJigyoshamei().clearValue();
            div.getKennsakuJyokenn().getTxtYubinNo().clearValue();
            div.getKennsakuJyokenn().getTxtJusho().clearDomain();
            div.getJigyoshaItirann().getDgJigyoshaItiran().getDataSource().clear();
            div.getTaishoJigyoshaKensaku().getKennsakuJyokenn().getDdlKennsakuKubun().setSelectedKey(前方一致_コード);
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

        List<KeyValueDataSource> dataSourceList = new ArrayList();

        for (JigyoshaKubun type : JigyoshaKubun.values()) {

            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(type.getコード());
            dataSource.setValue(type.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> get検索条件区分() {

        List<KeyValueDataSource> dataSource = new ArrayList();

        KeyValueDataSource KeyValue1 = new KeyValueDataSource();
        KeyValueDataSource KeyValue2 = new KeyValueDataSource();
        KeyValue1.setKey(前方一致_コード);
        KeyValue2.setKey(完全一致_コード);
        KeyValue1.setValue(前方一致);
        KeyValue2.setValue(完全一致);

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
        SearchResult<ServiceShuruiJigyoshaInputGuide> serviceShuruiJigyoshaInputGuide = jigyosha.getServiceShuruiJigyoshaInputGuide(RDate.getNowDate().getYearMonth());

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
