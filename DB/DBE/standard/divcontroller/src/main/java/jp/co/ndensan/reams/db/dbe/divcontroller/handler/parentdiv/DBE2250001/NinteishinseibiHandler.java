/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2250001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadatatorikomi.NinteiChosaDataTorikomiRelate;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuGaikyoTokkiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.ChosaKekkaNyuryokuTokkiCsvEntity;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.NinteishinseibiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2250001.dgNinteiChosaData_Row;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosadatatorikomi.NinteiChosaDataTorikomiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoTokki;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * 認定調査データ取込（モバイル）のHandlerラスです。
 *
 * @reamsid_L DBE-1870-010 houtianpeng
 */
public class NinteishinseibiHandler {

    private static final RString 状態_変更 = new RString("変更");
    private static final RString 状態_警告 = new RString("警告");
    private static final RString 状態_NG = new RString("ＮＧ");
    private static final RString 申請未登録 = new RString("申請未登録");
    private static final RString 依頼未登録 = new RString("依頼未登録");
    private static final RString 依頼未完了 = new RString("依頼未完了");
    private static final RString 一次判定済み = new RString("一次判定済み");
    private static final RString 特記事項未入力 = new RString("特記事項未入力");
    private static final RString 概況特記未入力 = new RString("概況特記未入力");
    private static final RString 必須調査票_パターン2 = new RString("2");
    private static final RString 必須調査票_パターン3 = new RString("3");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");
    private final NinteishinseibiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div NinteishinseibiDiv
     */
    public NinteishinseibiHandler(NinteishinseibiDiv div) {
        this.div = div;
    }

    /**
     * 初期化処理です。
     */
    public void initialize() {
        div.getDgNinteiChosaData().setDataSource(new ArrayList<dgNinteiChosaData_Row>());
        div.getBtnErrorListOutput().setDisabled(true);
    }

    /**
     * 認定調査一覧データグリッドを設定します。
     *
     * @param 基本調査データCsvEntityList ChosaKekkaNyuryokuCsvEntityのリスト
     * @param filePath_概況特記データ 概況特記データのファイルパス
     * @param filePath_特記情報データ 特記情報データのファイルパス
     * @param 認定調査結果入手_必須調査票 認定調査結果入手_必須調査票
     */
    public void set認定調査一覧データグリッド(List<ChosaKekkaNyuryokuCsvEntity> 基本調査データCsvEntityList,
            RString filePath_概況特記データ, RString filePath_特記情報データ, RString 認定調査結果入手_必須調査票) {
        Map<ShinseishoKanriNo, List<NinteichosahyoTokkijiko>> 特記事項Map = new HashMap<>();
        Map<ShinseishoKanriNo, GaikyoTokki> 概況特記事項Map = new HashMap<>();
        List<NinteichosahyoTokkijiko> 特記事項List;
        GaikyoTokki 概況特記事項;
        NinteiChosaDataTorikomiRelate 認定調査情報;
        ShinseishoKanriNo 申請書管理番号;
        int 認定調査依頼履歴番号;
        FlexibleDate 受領年月日 = FlexibleDate.getNowDate();
        NinteiChosaDataTorikomiManager manager = NinteiChosaDataTorikomiManager.createInstance();
        List<dgNinteiChosaData_Row> dataSource = new ArrayList<>();
        for (ChosaKekkaNyuryokuCsvEntity 基本調査データCsvEntity : 基本調査データCsvEntityList) {
            認定調査情報 = manager.get認定調査情報(基本調査データCsvEntity.get証記載保険者番号(),
                    基本調査データCsvEntity.get被保険者番号(), 基本調査データCsvEntity.get認定申請年月日());
            申請書管理番号 = get申請書管理番号(基本調査データCsvEntity, 認定調査情報);
            認定調査依頼履歴番号 = get認定調査依頼履歴番号(基本調査データCsvEntity, 認定調査情報);

            特記事項List = get特記事項List(filePath_特記情報データ, 基本調査データCsvEntity, 申請書管理番号, 認定調査依頼履歴番号);
            概況特記事項 = get概況特記情報(filePath_概況特記データ, 基本調査データCsvEntity, 申請書管理番号, 認定調査依頼履歴番号);
            dataSource.add(editRow(申請書管理番号, 認定調査依頼履歴番号, 基本調査データCsvEntity,
                    特記事項List, 概況特記事項, 認定調査情報, 認定調査結果入手_必須調査票, 受領年月日));
            if (申請書管理番号 != null && !申請書管理番号.isEmpty()) {
                特記事項Map.put(申請書管理番号, 特記事項List);
                概況特記事項Map.put(申請書管理番号, 概況特記事項);
            }
        }
        div.getDgNinteiChosaData().setDataSource(dataSource);
        div.getTxtNinzu().setValue(new Decimal(dataSource.size()));
        div.set特記事項Map(DataPassingConverter.serialize((HashMap) 特記事項Map));
        div.set概況特記事項Map(DataPassingConverter.serialize((HashMap) 概況特記事項Map));
    }

    /**
     * 認定調査一覧データグリッドに状態がNGのデータがあるか返します。
     *
     * @return true：認定調査一覧データグリッドに状態がNGのデータがある場合<br/>
     * true：認定調査一覧データグリッドに状態がNGのデータがない場合
     */
    public boolean existNGデータ() {
        for (dgNinteiChosaData_Row row : div.getDgNinteiChosaData().getDataSource()) {
            if (状態_NG.equals(row.getJyotai())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 認定調査一覧データグリッドの状態がNGの行のリストを返します。
     *
     * @return 認定調査一覧データグリッドの状態がNGの行のリスト
     */
    public List<dgNinteiChosaData_Row> getNG行() {
        List<dgNinteiChosaData_Row> ngRowList = new ArrayList<>();
        for (dgNinteiChosaData_Row row : div.getDgNinteiChosaData().getDataSource()) {
            if (状態_NG.equals(row.getJyotai())) {
                ngRowList.add(row);
            }
        }
        return ngRowList;
    }

    private dgNinteiChosaData_Row editRow(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            ChosaKekkaNyuryokuCsvEntity entity,
            List<NinteichosahyoTokkijiko> 特記事項List,
            GaikyoTokki 概況特記事項,
            NinteiChosaDataTorikomiRelate 認定調査情報,
            RString 認定調査結果入手_必須調査票,
            FlexibleDate 受領年月日) {
        dgNinteiChosaData_Row row = new dgNinteiChosaData_Row();
        row.setHokenja(entity.get保険者名());
        row.getNinteiShinseiYMD().setValue(convertFlexibleDate(entity.get認定申請年月日()));
        row.getHihokenshaNo().setValue(entity.get被保険者番号());
        row.setHihokenshaName(entity.get被保険者氏名());
        row.setShokisaiHokenshaNo(entity.get証記載保険者番号());
        row.setNinteiShinseiShinseijiKubunCode(NinteiShinseiShinseijiKubunCode.to名称OrDefault(entity.get認定申請区分申請時コード(), RString.EMPTY));
        row.getNinteichosaIraiKanryoYMD().setValue(convertFlexibleDate(entity.get認定調査依頼完了年月日()));
        row.setNinteiChosaItakusakiCode(entity.get認定調査委託先コード());
        row.setNinteiChosaItakusakimei(entity.get調査委託先());
        row.setNinteiChosainCode(entity.get認定調査員コード());
        row.setNinteiChosainName(entity.get調査員氏名());
        row.getNinteichosaJisshiYMD().setValue(convertFlexibleDate(entity.get認定調査実施年月日()));
        row.setShinseishoKanriNo(申請書管理番号.value());
        row.getNinteichosaIraiRirekiNo().setValue(new Decimal(認定調査依頼履歴番号));
        row.setKoroshoIfShikibetsuCode(entity.get厚労省IF識別コード());
        row.setNinchishoNichijoSeikatsuJiritsudoCode(
                (!RString.isNullOrEmpty(entity.get認定調査_認知症高齢者の日常生活自立度コード()))
                ? entity.get認定調査_認知症高齢者の日常生活自立度コード()
                : RString.EMPTY);
        row.setShogaiNichijoSeikatsuJiritsudoCode(
                (!RString.isNullOrEmpty(entity.get認定調査_障害高齢者の日常生活自立度コード()))
                ? entity.get認定調査_障害高齢者の日常生活自立度コード()
                : RString.EMPTY);
        row.setGaikyoTokkiTextImageKubun(entity.get概況特記テキスト_イメージ区分コード());
        row.setJutakuKaishu(entity.get住宅改修改修箇所());
        row.setTokubetsuKyufuService(entity.get市町村特別給付サービス種類名());
        row.setZaitakuService(entity.get介護保険給付以外の在宅サービス種類名());
        row.setNinteichousaIraiKubunCode(
                !RString.isNullOrEmpty(entity.get認定調査依頼区分コード())
                ? entity.get認定調査依頼区分コード()
                : (認定調査情報 != null ? 認定調査情報.get認定調査依頼区分コード() : RString.EMPTY));
        row.setNinteichosaIraiKaisu(entity.get認定調査回数());
        row.getNinteichosaJuryoYMD().setValue(受領年月日);
        row.setNinteiChosaKubunCode(
                !RString.isNullOrEmpty(entity.get認定調査区分コード())
                ? entity.get認定調査区分コード()
                : (認定調査情報 != null ? 認定調査情報.get認定調査区分コード() : RString.EMPTY));
        row.setChosaJisshiBashoCode(entity.get認定調査実施場所コード());
        row.setChosaJisshiBashoMeisho(entity.get認定調査実施場所名称());
        row.setServiceKubunCode(
                (!RString.isNullOrEmpty(entity.get認定調査_サービス区分コード()))
                ? entity.get認定調査_サービス区分コード()
                : RString.EMPTY);
        row.setRiyoShisetsuShimei(entity.get利用施設名());
        row.setRiyoShisetsuJusho(entity.get利用施設住所());
        row.setRiyoShisetsuTelNo(entity.get利用施設電話番号());
        row.setRiyoShisetsuYubinNo(entity.get利用施設郵便番号());
        row.setTokki(entity.get特記());
        row.getTokkijikoUketsukeYMD().setValue(convertFlexibleDate(entity.get認定調査特記事項受付年月日()));
        row.getTokkijikoJuryoYMD().setValue(受領年月日);

        //5207
        row.setServiceJokyoRemban(createCommaSplitString(createサービス状況連番List(entity)));
        row.setServiceJokyo(createCommaSplitString(createサービス状況List(entity)));

        //5208
        row.setServiceJokyoFlagRemban(createCommaSplitString(createサービス状況フラグ連番List(entity)));
        row.setServiceJokyoFlag(createCommaSplitString(createサービス状況フラグList(entity)));

        //5209
        row.setServiceJokyoKinyuRemban(createCommaSplitString(createサービス状況記入連番List(entity)));
        row.setServiceJokyoKinyu(createCommaSplitString(createサービス状況記入List(entity)));

        //5210
        row.setShisetsuRiyoFlagRemban(createCommaSplitString(create施設利用連番List(entity)));
        row.setShisetsuRiyoFlag(createCommaSplitString(create施設利用フラグList(entity)));

        //5211
        row.setRemban(createCommaSplitString(create調査項目連番List(entity)));
        row.setResearchItem(createCommaSplitString(create調査項目内容List(entity)));

        //特記事項
        row.setNinteichosaTokkijikoNoRemban(createCommaSplitString(create特記事項表示文字列List(特記事項List)));

        //概況特記事項
        if (概況特記事項 != null) {
            row.setShuso(概況特記事項.get概況特記事項_主訴());
            row.setKazokuJokyo(概況特記事項.get概況特記事項_家族状況());
            row.setKyojuKankyo(概況特記事項.get概況特記事項_居住環境());
            row.setKikaiKiki(概況特記事項.get概況特記事項_機器_器械());
        } else {
            row.setShuso(RString.EMPTY);
            row.setKazokuJokyo(RString.EMPTY);
            row.setKyojuKankyo(RString.EMPTY);
            row.setKikaiKiki(RString.EMPTY);
        }
        set状態(row, entity, 特記事項List, 概況特記事項, 認定調査結果入手_必須調査票, 認定調査情報);
        return row;
    }

    private List<RString> createサービス状況連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況連番List = new ArrayList<>();
        サービス状況連番List.add(entity.getサービスの状況連番01());
        サービス状況連番List.add(entity.getサービスの状況連番02());
        サービス状況連番List.add(entity.getサービスの状況連番03());
        サービス状況連番List.add(entity.getサービスの状況連番04());
        サービス状況連番List.add(entity.getサービスの状況連番05());
        サービス状況連番List.add(entity.getサービスの状況連番06());
        サービス状況連番List.add(entity.getサービスの状況連番07());
        サービス状況連番List.add(entity.getサービスの状況連番08());
        サービス状況連番List.add(entity.getサービスの状況連番09());
        サービス状況連番List.add(entity.getサービスの状況連番10());
        サービス状況連番List.add(entity.getサービスの状況連番11());
        サービス状況連番List.add(entity.getサービスの状況連番12());
        サービス状況連番List.add(entity.getサービスの状況連番13());
        サービス状況連番List.add(entity.getサービスの状況連番14());
        サービス状況連番List.add(entity.getサービスの状況連番15());
        サービス状況連番List.add(entity.getサービスの状況連番16());
        サービス状況連番List.add(entity.getサービスの状況連番17());
        サービス状況連番List.add(entity.getサービスの状況連番18());
        サービス状況連番List.add(entity.getサービスの状況連番19());
        サービス状況連番List.add(entity.getサービスの状況連番20());
        return サービス状況連番List;
    }

    private List<RString> createサービス状況List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況List = new ArrayList<>();
        サービス状況List.add(entity.getサービスの状況01());
        サービス状況List.add(entity.getサービスの状況02());
        サービス状況List.add(entity.getサービスの状況03());
        サービス状況List.add(entity.getサービスの状況04());
        サービス状況List.add(entity.getサービスの状況05());
        サービス状況List.add(entity.getサービスの状況06());
        サービス状況List.add(entity.getサービスの状況07());
        サービス状況List.add(entity.getサービスの状況08());
        サービス状況List.add(entity.getサービスの状況09());
        サービス状況List.add(entity.getサービスの状況10());
        サービス状況List.add(entity.getサービスの状況11());
        サービス状況List.add(entity.getサービスの状況12());
        サービス状況List.add(entity.getサービスの状況13());
        サービス状況List.add(entity.getサービスの状況14());
        サービス状況List.add(entity.getサービスの状況15());
        サービス状況List.add(entity.getサービスの状況16());
        サービス状況List.add(entity.getサービスの状況17());
        サービス状況List.add(entity.getサービスの状況18());
        サービス状況List.add(entity.getサービスの状況19());
        サービス状況List.add(entity.getサービスの状況20());
        return サービス状況List;
    }

    private List<RString> createサービス状況フラグ連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況フラグ連番List = new ArrayList<>();
        サービス状況フラグ連番List.add(entity.getサービスの状況フラグ連番());
        return サービス状況フラグ連番List;
    }

    private List<RString> createサービス状況フラグList(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況フラグList = new ArrayList<>();
        サービス状況フラグList.add(entity.getサービスの状況フラグ());
        return サービス状況フラグList;
    }

    private List<RString> createサービス状況記入連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況記入連番List = new ArrayList<>();
        サービス状況記入連番List.add(entity.get記入項目連番01());
        サービス状況記入連番List.add(entity.get記入項目連番02());
        return サービス状況記入連番List;
    }

    private List<RString> createサービス状況記入List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> サービス状況記入List = new ArrayList<>();
        サービス状況記入List.add(entity.getサービスの状況記入01());
        サービス状況記入List.add(entity.getサービスの状況記入02());
        return サービス状況記入List;
    }

    private List<RString> create施設利用連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 施設利用連番List = new ArrayList<>();
        施設利用連番List.add(entity.get施設利用連番01());
        施設利用連番List.add(entity.get施設利用連番02());
        施設利用連番List.add(entity.get施設利用連番03());
        施設利用連番List.add(entity.get施設利用連番04());
        施設利用連番List.add(entity.get施設利用連番05());
        施設利用連番List.add(entity.get施設利用連番06());
        施設利用連番List.add(entity.get施設利用連番07());
        施設利用連番List.add(entity.get施設利用連番08());
        施設利用連番List.add(entity.get施設利用連番09());
        return 施設利用連番List;
    }

    private List<RString> create施設利用フラグList(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 施設利用フラグList = new ArrayList<>();
        施設利用フラグList.add(entity.get施設利用フラグ01());
        施設利用フラグList.add(entity.get施設利用フラグ02());
        施設利用フラグList.add(entity.get施設利用フラグ03());
        施設利用フラグList.add(entity.get施設利用フラグ04());
        施設利用フラグList.add(entity.get施設利用フラグ05());
        施設利用フラグList.add(entity.get施設利用フラグ06());
        施設利用フラグList.add(entity.get施設利用フラグ07());
        施設利用フラグList.add(entity.get施設利用フラグ08());
        施設利用フラグList.add(entity.get施設利用フラグ09());
        return 施設利用フラグList;
    }

    private List<RString> create調査項目連番List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 調査項目連番List = new ArrayList<>();
        調査項目連番List.add(entity.get調査項目連番01());
        調査項目連番List.add(entity.get調査項目連番02());
        調査項目連番List.add(entity.get調査項目連番03());
        調査項目連番List.add(entity.get調査項目連番04());
        調査項目連番List.add(entity.get調査項目連番05());
        調査項目連番List.add(entity.get調査項目連番06());
        調査項目連番List.add(entity.get調査項目連番07());
        調査項目連番List.add(entity.get調査項目連番08());
        調査項目連番List.add(entity.get調査項目連番09());
        調査項目連番List.add(entity.get調査項目連番10());
        調査項目連番List.add(entity.get調査項目連番11());
        調査項目連番List.add(entity.get調査項目連番12());
        調査項目連番List.add(entity.get調査項目連番13());
        調査項目連番List.add(entity.get調査項目連番14());
        調査項目連番List.add(entity.get調査項目連番15());
        調査項目連番List.add(entity.get調査項目連番16());
        調査項目連番List.add(entity.get調査項目連番17());
        調査項目連番List.add(entity.get調査項目連番18());
        調査項目連番List.add(entity.get調査項目連番19());
        調査項目連番List.add(entity.get調査項目連番20());
        調査項目連番List.add(entity.get調査項目連番21());
        調査項目連番List.add(entity.get調査項目連番22());
        調査項目連番List.add(entity.get調査項目連番23());
        調査項目連番List.add(entity.get調査項目連番24());
        調査項目連番List.add(entity.get調査項目連番25());
        調査項目連番List.add(entity.get調査項目連番26());
        調査項目連番List.add(entity.get調査項目連番27());
        調査項目連番List.add(entity.get調査項目連番28());
        調査項目連番List.add(entity.get調査項目連番29());
        調査項目連番List.add(entity.get調査項目連番30());
        調査項目連番List.add(entity.get調査項目連番31());
        調査項目連番List.add(entity.get調査項目連番32());
        調査項目連番List.add(entity.get調査項目連番33());
        調査項目連番List.add(entity.get調査項目連番34());
        調査項目連番List.add(entity.get調査項目連番35());
        調査項目連番List.add(entity.get調査項目連番36());
        調査項目連番List.add(entity.get調査項目連番37());
        調査項目連番List.add(entity.get調査項目連番38());
        調査項目連番List.add(entity.get調査項目連番39());
        調査項目連番List.add(entity.get調査項目連番40());
        調査項目連番List.add(entity.get調査項目連番41());
        調査項目連番List.add(entity.get調査項目連番42());
        調査項目連番List.add(entity.get調査項目連番43());
        調査項目連番List.add(entity.get調査項目連番44());
        調査項目連番List.add(entity.get調査項目連番45());
        調査項目連番List.add(entity.get調査項目連番46());
        調査項目連番List.add(entity.get調査項目連番47());
        調査項目連番List.add(entity.get調査項目連番48());
        調査項目連番List.add(entity.get調査項目連番49());
        調査項目連番List.add(entity.get調査項目連番50());
        調査項目連番List.add(entity.get調査項目連番51());
        調査項目連番List.add(entity.get調査項目連番52());
        調査項目連番List.add(entity.get調査項目連番53());
        調査項目連番List.add(entity.get調査項目連番54());
        調査項目連番List.add(entity.get調査項目連番55());
        調査項目連番List.add(entity.get調査項目連番56());
        調査項目連番List.add(entity.get調査項目連番57());
        調査項目連番List.add(entity.get調査項目連番58());
        調査項目連番List.add(entity.get調査項目連番59());
        調査項目連番List.add(entity.get調査項目連番60());
        調査項目連番List.add(entity.get調査項目連番61());
        調査項目連番List.add(entity.get調査項目連番62());
        調査項目連番List.add(entity.get調査項目連番63());
        調査項目連番List.add(entity.get調査項目連番64());
        調査項目連番List.add(entity.get調査項目連番65());
        調査項目連番List.add(entity.get調査項目連番66());
        調査項目連番List.add(entity.get調査項目連番67());
        調査項目連番List.add(entity.get調査項目連番68());
        調査項目連番List.add(entity.get調査項目連番69());
        調査項目連番List.add(entity.get調査項目連番70());
        調査項目連番List.add(entity.get調査項目連番71());
        調査項目連番List.add(entity.get調査項目連番72());
        調査項目連番List.add(entity.get調査項目連番73());
        調査項目連番List.add(entity.get調査項目連番74());
        return 調査項目連番List;
    }

    private List<RString> create調査項目内容List(ChosaKekkaNyuryokuCsvEntity entity) {
        List<RString> 調査項目内容List = new ArrayList<>();
        調査項目内容List.add(entity.get内容01());
        調査項目内容List.add(entity.get内容02());
        調査項目内容List.add(entity.get内容03());
        調査項目内容List.add(entity.get内容04());
        調査項目内容List.add(entity.get内容05());
        調査項目内容List.add(entity.get内容06());
        調査項目内容List.add(entity.get内容07());
        調査項目内容List.add(entity.get内容08());
        調査項目内容List.add(entity.get内容09());
        調査項目内容List.add(entity.get内容10());
        調査項目内容List.add(entity.get内容11());
        調査項目内容List.add(entity.get内容12());
        調査項目内容List.add(entity.get内容13());
        調査項目内容List.add(entity.get内容14());
        調査項目内容List.add(entity.get内容15());
        調査項目内容List.add(entity.get内容16());
        調査項目内容List.add(entity.get内容17());
        調査項目内容List.add(entity.get内容18());
        調査項目内容List.add(entity.get内容19());
        調査項目内容List.add(entity.get内容20());
        調査項目内容List.add(entity.get内容21());
        調査項目内容List.add(entity.get内容22());
        調査項目内容List.add(entity.get内容23());
        調査項目内容List.add(entity.get内容24());
        調査項目内容List.add(entity.get内容25());
        調査項目内容List.add(entity.get内容26());
        調査項目内容List.add(entity.get内容27());
        調査項目内容List.add(entity.get内容28());
        調査項目内容List.add(entity.get内容29());
        調査項目内容List.add(entity.get内容30());
        調査項目内容List.add(entity.get内容31());
        調査項目内容List.add(entity.get内容32());
        調査項目内容List.add(entity.get内容33());
        調査項目内容List.add(entity.get内容34());
        調査項目内容List.add(entity.get内容35());
        調査項目内容List.add(entity.get内容36());
        調査項目内容List.add(entity.get内容37());
        調査項目内容List.add(entity.get内容38());
        調査項目内容List.add(entity.get内容39());
        調査項目内容List.add(entity.get内容40());
        調査項目内容List.add(entity.get内容41());
        調査項目内容List.add(entity.get内容42());
        調査項目内容List.add(entity.get内容43());
        調査項目内容List.add(entity.get内容44());
        調査項目内容List.add(entity.get内容45());
        調査項目内容List.add(entity.get内容46());
        調査項目内容List.add(entity.get内容47());
        調査項目内容List.add(entity.get内容48());
        調査項目内容List.add(entity.get内容49());
        調査項目内容List.add(entity.get内容50());
        調査項目内容List.add(entity.get内容51());
        調査項目内容List.add(entity.get内容52());
        調査項目内容List.add(entity.get内容53());
        調査項目内容List.add(entity.get内容54());
        調査項目内容List.add(entity.get内容55());
        調査項目内容List.add(entity.get内容56());
        調査項目内容List.add(entity.get内容57());
        調査項目内容List.add(entity.get内容58());
        調査項目内容List.add(entity.get内容59());
        調査項目内容List.add(entity.get内容60());
        調査項目内容List.add(entity.get内容61());
        調査項目内容List.add(entity.get内容62());
        調査項目内容List.add(entity.get内容63());
        調査項目内容List.add(entity.get内容64());
        調査項目内容List.add(entity.get内容65());
        調査項目内容List.add(entity.get内容66());
        調査項目内容List.add(entity.get内容67());
        調査項目内容List.add(entity.get内容68());
        調査項目内容List.add(entity.get内容69());
        調査項目内容List.add(entity.get内容70());
        調査項目内容List.add(entity.get内容71());
        調査項目内容List.add(entity.get内容72());
        調査項目内容List.add(entity.get内容73());
        調査項目内容List.add(entity.get内容74());
        return 調査項目内容List;
    }

    private RString createCommaSplitString(List<RString> valueList) {
        if (valueList.isEmpty()) {
            return RString.EMPTY;
        }
        RStringBuilder rsb = new RStringBuilder();
        for (RString value : valueList) {
            rsb.append(value).append(",");
        }
        return rsb.substring(0, rsb.length() - 1);
    }

    private List<RString> create特記事項表示文字列List(List<NinteichosahyoTokkijiko> 特記事項List) {
        List<RString> valueList = new ArrayList<>();
        for (NinteichosahyoTokkijiko 特記事項 : 特記事項List) {
            RString 特記事項番号 = 特記事項.get認定調査特記事項番号();
            RString 特記事項連番 = new RString(特記事項.get認定調査特記事項連番());
            RStringBuilder rsb = new RStringBuilder();
            rsb.append("{").append(特記事項番号).append(",").append(特記事項連番).append("}");
            valueList.add(rsb.toRString());
        }
        return valueList;
    }

    private void set状態(dgNinteiChosaData_Row row, ChosaKekkaNyuryokuCsvEntity entity, List<NinteichosahyoTokkijiko> 特記事項List,
            GaikyoTokki 概況特記事項, RString 認定調査結果入手_必須調査票, NinteiChosaDataTorikomiRelate 認定調査情報) {
        if ((entity.get申請書管理番号().isEmpty() || entity.get認定調査依頼履歴番号().isEmpty())
                && 認定調査情報 == null) {
            row.setJyotai(状態_NG);
            row.setErrorJiyu(申請未登録);
            div.getBtnErrorListOutput().setDisabled(false);
        } else if (認定調査情報 == null
                || !認定調査情報.exist認定調査依頼情報()
                || 認定調査情報.exist論理削除フラグ()) {
            row.setJyotai(状態_NG);
            row.setErrorJiyu(依頼未登録);
            div.getBtnErrorListOutput().setDisabled(false);
        } else if (認定調査情報.get認定調査依頼完了日() == null) {
            row.setJyotai(状態_NG);
            row.setErrorJiyu(依頼未完了);
            div.getBtnErrorListOutput().setDisabled(false);
        } else if (認定調査情報.get認定調査依頼完了日() != null
                && 認定調査情報.exist本判定一次判定データ()) {
            row.setJyotai(状態_NG);
            row.setErrorJiyu(一次判定済み);
            div.getBtnErrorListOutput().setDisabled(false);
        } else if ((必須調査票_パターン2.equals(認定調査結果入手_必須調査票)
                || 必須調査票_パターン3.equals(認定調査結果入手_必須調査票))
                && 特記事項List.isEmpty()) {
            row.setJyotai(状態_警告);
            row.setErrorJiyu(特記事項未入力);
        } else if (必須調査票_パターン3.equals(認定調査結果入手_必須調査票)
                && 概況特記事項 == null) {
            row.setJyotai(状態_警告);
            row.setErrorJiyu(概況特記未入力);
        } else {
            row.setJyotai(状態_変更);
            row.setErrorJiyu(RString.EMPTY);
        }
    }

    private List<NinteichosahyoTokkijiko> get特記事項List(RString ファイルパス_特記情報データ,
            ChosaKekkaNyuryokuCsvEntity entity, ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号) {
        List<NinteichosahyoTokkijiko> 特記事項List = new ArrayList<>();
        if (!ファイルパス_特記情報データ.isEmpty()) {
            for (ChosaKekkaNyuryokuTokkiCsvEntity 特記情報データ : データ取込_特記情報データ(ファイルパス_特記情報データ)) {
                if (!特記情報データ.get認定調査特記事項番号().isEmpty()
                        && 申請書管理番号.value().equals(特記情報データ.get申請書管理番号())) {
                    int 認定調査特記事項連番 = (NumberUtils.isNumber(特記情報データ.get認定調査特記事項連番().toString()))
                            ? Integer.parseInt(特記情報データ.get認定調査特記事項連番().toString())
                            : 0;
                    特記事項List.add(
                            new NinteichosahyoTokkijiko(
                                    申請書管理番号,
                                    認定調査依頼履歴番号,
                                    特記情報データ.get認定調査特記事項番号(),
                                    認定調査特記事項連番,
                                    entity.get概況特記テキスト_イメージ区分コード(),
                                    new Code(GenponMaskKubun.原本.getコード()))
                            .createBuilderForEdit()
                            .set特記事項(特記情報データ.get特記事項())
                            .build());
                }
            }
        }
        return 特記事項List;
    }

    private List<ChosaKekkaNyuryokuTokkiCsvEntity> データ取込_特記情報データ(RString ファイルPath) {
        CsvReader csvReader = new CsvReader.InstanceBuilder(ファイルPath, ChosaKekkaNyuryokuTokkiCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER)
                .setEncode(Encode.SJIS)
                .hasHeader(false)
                .setNewLine(NewLine.CRLF)
                .build();
        return readCsvFile_特記情報データ(csvReader);
    }

    private List<ChosaKekkaNyuryokuTokkiCsvEntity> readCsvFile_特記情報データ(CsvReader csvReader) {
        List<ChosaKekkaNyuryokuTokkiCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ChosaKekkaNyuryokuTokkiCsvEntity entity = (ChosaKekkaNyuryokuTokkiCsvEntity) csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    private GaikyoTokki get概況特記情報(RString ファイルパス_概況特記データ,
            ChosaKekkaNyuryokuCsvEntity entity, ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号) {
        GaikyoTokki 概況特記事項 = null;
        if (!ファイルパス_概況特記データ.isEmpty()) {
            for (ChosaKekkaNyuryokuGaikyoTokkiCsvEntity 概況特記データ : データ取込_概況特記データ(ファイルパス_概況特記データ)) {
                概況特記事項 = new GaikyoTokki(
                        申請書管理番号,
                        認定調査依頼履歴番号,
                        entity.get概況特記テキスト_イメージ区分コード(),
                        new Code(GenponMaskKubun.原本.getコード()))
                        .createBuilderForEdit()
                        .set住宅改修(entity.get住宅改修改修箇所())
                        .set市町村特別給付サービス種類名(entity.get市町村特別給付サービス種類名())
                        .set介護保険給付以外の在宅サービス種類名(entity.get介護保険給付以外の在宅サービス種類名())
                        .set概況特記事項_主訴(概況特記データ.get概況特記事項主訴())
                        .set概況特記事項_家族状況(概況特記データ.get概況特記事項家族状況())
                        .set概況特記事項_居住環境(概況特記データ.get概況特記事項居住環境())
                        .set概況特記事項_機器_器械(概況特記データ.get概況特記事項機器_器械())
                        .build();
            }
        }
        return 概況特記事項;
    }

    private List<ChosaKekkaNyuryokuGaikyoTokkiCsvEntity> データ取込_概況特記データ(RString ファイルPath) {
        CsvReader csvReader = new CsvReader.InstanceBuilder(ファイルPath, ChosaKekkaNyuryokuGaikyoTokkiCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.CRLF).build();
        return readCsvFile_概況特記データ(csvReader);
    }

    private List<ChosaKekkaNyuryokuGaikyoTokkiCsvEntity> readCsvFile_概況特記データ(CsvReader csvReader) {
        List<ChosaKekkaNyuryokuGaikyoTokkiCsvEntity> csvEntityList = new ArrayList<>();
        while (true) {
            ChosaKekkaNyuryokuGaikyoTokkiCsvEntity entity = (ChosaKekkaNyuryokuGaikyoTokkiCsvEntity) csvReader.readLine();
            if (entity != null) {
                csvEntityList.add(entity);
            } else {
                break;
            }
        }
        csvReader.close();
        return csvEntityList;
    }

    private ShinseishoKanriNo get申請書管理番号(ChosaKekkaNyuryokuCsvEntity 基本調査データCsvEntity,
            NinteiChosaDataTorikomiRelate 認定調査情報) {
        if (!RString.isNullOrEmpty(基本調査データCsvEntity.get申請書管理番号())) {
            return new ShinseishoKanriNo(基本調査データCsvEntity.get申請書管理番号());
        } else if (認定調査情報 != null) {
            return 認定調査情報.get申請書管理番号();
        } else {
            return ShinseishoKanriNo.EMPTY;
        }
    }

    private int get認定調査依頼履歴番号(ChosaKekkaNyuryokuCsvEntity 基本調査データCsvEntity,
            NinteiChosaDataTorikomiRelate 認定調査情報) {
        if (!RString.isNullOrEmpty(基本調査データCsvEntity.get認定調査依頼履歴番号())
                && NumberUtils.isNumber(基本調査データCsvEntity.get認定調査依頼履歴番号().toString())) {
            return Integer.parseInt(基本調査データCsvEntity.get認定調査依頼履歴番号().toString());
        } else if (認定調査情報 != null) {
            return 認定調査情報.get認定調査依頼履歴番号();
        } else {
            return 0;
        }
    }

    private FlexibleDate convertFlexibleDate(RString 年月日) {
        return (FlexibleDate.canConvert(年月日)) ? new FlexibleDate(年月日) : FlexibleDate.EMPTY;
    }
}
