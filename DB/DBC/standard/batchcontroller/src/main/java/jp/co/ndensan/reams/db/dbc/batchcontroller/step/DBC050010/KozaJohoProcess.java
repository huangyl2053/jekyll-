/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.KozaNayoseHoho;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.GyomubetsuPrimaryKeyMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.KozaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.KozaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.KozaJohoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050010.IKozaJohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.KozaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.koza.YokinShubetsuPattern;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.KozaYotoKubunType;
import jp.co.ndensan.reams.ua.uax.definition.core.valueobject.code.KozaYotoKubunCodeValue;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.ur.urc.business.core.shunokamoku.shunokamoku.IShunoKamoku;
import jp.co.ndensan.reams.ur.urc.definition.core.shunokamoku.shunokamoku.ShunoKamokuShubetsu;
import jp.co.ndensan.reams.ur.urc.service.core.shunokamoku.kamoku.ShunoKamokuFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還口座払の口座情報取得_Process処理クラスです．
 *
 * @reamsid_L DBC-2180-030 donghj
 */
public class KozaJohoProcess extends BatchProcessBase<KozaJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IKozaJohoMapper.get口座情報");
    private KozaJohoProcessParameter parameter;
    private KozaJohoMybatisParameter mybatisParameter;
    private static final RString RSTRING1 = new RString("1");
    private static final RString RSTRING2 = new RString("2");
    private static final RString RSTRING3 = new RString("3");
    private static final RString ゼロ1 = new RString("0");
    private static final RString ゼロ3 = new RString("000");
    private static final RString ゼロ4 = new RString("0000");
    private static final RString ゼロ6 = new RString("000000");
    private static final RString ゼロ7 = new RString("0000000");
    private static final RString ゼロ10 = new RString("0000000000");
    private static final int INT1 = 1;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT6 = 6;
    private static final int INT7 = 7;
    private static final int INT10 = 10;
    private RString 支払方法区分コード;
    private RString 口座名寄せキー;
    private RString 金融機関コード;
    private RString 支店コード;
    private RString 預金種別コード;
    private RString 口座番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 整理番号;
    private RString 履歴番号;

    @Override
    protected void initialize() {
        IKozaJohoMapper mapper = getMapper(IKozaJohoMapper.class);
        支払方法区分コード = mapper.get支払方法区分コード();
        RString データ区分 = mapper.getデータ区分();
        if (RSTRING2.equals(支払方法区分コード)) {
            IShunoKamoku 介護給付 = null;
            if (RSTRING1.equals(データ区分)) {
                介護給付 = ShunoKamokuFinder.createInstance().get科目(ShunoKamokuShubetsu.介護給付_償還);
            } else if (RSTRING2.equals(データ区分)) {
                介護給付 = ShunoKamokuFinder.createInstance().get科目(ShunoKamokuShubetsu.介護給付_高額);
            }
            GyomubetsuPrimaryKeyMybatisParameter mybatis = new GyomubetsuPrimaryKeyMybatisParameter();
            KamokuCode 科目コード;
            if (介護給付 != null) {
                科目コード = 介護給付.getコード();
            } else {
                科目コード = KamokuCode.EMPTY;
            }
            mybatis.set科目コード(科目コード);
            RString 業務別主キー = mapper.get業務別主キー(mybatis);
            KozaSearchKeyBuilder searchKey = new KozaSearchKeyBuilder();
            searchKey.set業務コード(GyomuCode.DB介護保険);
            searchKey.setサブ業務コード(SubGyomuCode.DBC介護給付);
            searchKey.set科目コード(科目コード);
            if (業務別主キー != null) {
                searchKey.set業務別主キー(業務別主キー);
            }
            searchKey.set用途区分(new KozaYotoKubunCodeValue(KozaYotoKubunType.振込口座.getCode()));
            searchKey.set基準日(new FlexibleDate(RDate.getNowDate().toDateString()));
            IKozaSearchKey key = searchKey.build();
            List<KamokuCode> kamokuList = new ArrayList<>();
            kamokuList.add(科目コード);
            mybatisParameter = new KozaJohoMybatisParameter(key, kamokuList, データ区分, 支払方法区分コード);
        } else if (RSTRING3.equals(支払方法区分コード)) {
            mybatisParameter = new KozaJohoMybatisParameter(null, null, データ区分, 支払方法区分コード);
        }

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter furikomiDetailTempTable;

    @Override
    protected void createWriter() {
        furikomiDetailTempTable = BatchEntityCreatedTempTableWriterBuilders.createBuilder(FurikomiDetailTempTableEntity.class)
                .tempTableName(FurikomiDetailTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(KozaJohoEntity entity) {
        FurikomiDetailTempTableEntity tempTable = entity.get振込明細一時Entity();
        if (RSTRING2.equals(支払方法区分コード)) {
            TokuteiKozaRelateEntity tokuteiKozaRelateEntity = new TokuteiKozaRelateEntity();
            IKoza 口座 = new Koza(tokuteiKozaRelateEntity);
            EditedKoza editorKoza = new EditedKoza(口座);

            tempTable.setKozaDataFlag(true);
            setTempTable口座(口座, tempTable);
            setTempTableEditorKoza(editorKoza, tempTable);
            tempTable.setKozaNayoseKey(set口座名寄せキー(口座, editorKoza, tempTable));

        } else if (RSTRING3.equals(支払方法区分コード)) {
            FlexibleDate 依頼日 = new FlexibleDate(parameter.get振込指定年月日().toDateString());
            //TODO QA553
            KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
            KinyuKikan 金融機関情報 = null;
            DbT3077JuryoininKeiyakuJigyoshaEntity dbt3077Entity = entity.get受領委任契約事業者Entity();
            if (dbt3077Entity != null) {
                金融機関情報 = set金融機関情報(dbt3077Entity, 金融機関情報, kinyuKikanManager, 依頼日);
                setsetTempTable2(dbt3077Entity, 金融機関情報, tempTable);
            }
            tempTable.setKozaDataFlag(true);
            tempTable.setKozaShikibetsuCode(ShikibetsuCode.EMPTY);
            if (金融機関情報 != null) {
                tempTable.setKinyuKikanName(金融機関情報.get金融機関名称());
                tempTable.setKinyuKikanKanaName(金融機関情報.get金融機関カナ名称());
            }
            tempTable.setKozaNayoseKey(set口座名寄せキー2(dbt3077Entity, tempTable));
        }

        furikomiDetailTempTable.update(tempTable);

    }

    private KinyuKikan set金融機関情報(DbT3077JuryoininKeiyakuJigyoshaEntity dbt3077Entity, KinyuKikan 金融機関情報,
            KinyuKikanManager kinyuKikanManager, FlexibleDate 依頼日) {
        KinyuKikanCode kinyuKikanCode = dbt3077Entity.getKinyuKikanCode();
        if (kinyuKikanCode != null && !kinyuKikanCode.isEmpty()) {
            金融機関情報 = kinyuKikanManager.getValidKinyuKikanOn(依頼日, kinyuKikanCode.value());
        }
        return 金融機関情報;
    }

    private void setsetTempTable2(DbT3077JuryoininKeiyakuJigyoshaEntity dbt3077Entity, KinyuKikan 金融機関情報,
            FurikomiDetailTempTableEntity tempTable) {

        tempTable.setKinyuKikanCode(dbt3077Entity.getKinyuKikanCode());
        KinyuKikanShitenCode shitenCode = dbt3077Entity.getShitenCode();
        if (shitenCode != null && !shitenCode.isEmpty()) {
            tempTable.setKinyuKikanShitenCode(shitenCode);
            if (金融機関情報 != null) {
                set支店(金融機関情報, tempTable, shitenCode);
            }
        }
        RString 口座種別 = dbt3077Entity.getKozaShubetsu();
        if (口座種別 != null && !口座種別.isEmpty() && 金融機関情報 != null) {
            YokinShubetsuPattern 預金種別 = 金融機関情報.get預金種別(口座種別);
            if (預金種別 != null) {
                tempTable.setYokinShubetsuName(預金種別.get預金種別略称());
            }
        }
        tempTable.setYokinShubetsuCode(口座種別);
        tempTable.setKozaNo(dbt3077Entity.getKozaNo());
        AtenaMeisho 口座名義人 = dbt3077Entity.getKozaMeiginin();
        if (口座名義人 != null && !口座名義人.isEmpty()) {
            tempTable.setKozaMeiginin(new AtenaKanaMeisho(口座名義人.value()));
        }
//        AtenaKanaMeisho 口座名義人漢字 = dbt3077Entity.getKozaMeigininKana();
//        if (口座名義人漢字 != null && !口座名義人漢字.isEmpty()) {
//            tempTable.setKozaMeigininKanji(new AtenaMeisho(口座名義人漢字.value()));
//        }TODO QA553

    }

    private void set支店(KinyuKikan 金融機関情報, FurikomiDetailTempTableEntity tempTable, KinyuKikanShitenCode shitenCode) {
        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        if (!金融機関情報.isゆうちょ銀行()) {
            KinyuKikanShiten 支店 = 金融機関情報.get支店(shitenCode, システム日付);
            tempTable.setKinyuKikanShitenName(支店.get支店名称());
            tempTable.setKinyuKikanShitenKanaName(支店.get支店カナ名称());
        } else {
            tempTable.setKinyuKikanShitenName(RString.EMPTY);
            tempTable.setKinyuKikanShitenKanaName(RString.EMPTY);
        }
    }

    private void setTempTable口座(IKoza 口座, FurikomiDetailTempTableEntity tempTable) {
        tempTable.setKozaShikibetsuCode(口座.get識別コード());
        tempTable.setKinyuKikanCode(口座.get金融機関コード());
        if (口座.get金融機関() != null) {
            tempTable.setKinyuKikanName(口座.get金融機関().get金融機関名称());
            tempTable.setKinyuKikanKanaName(口座.get金融機関().get金融機関カナ名称());
        }
        if (口座.get預金種別() != null) {
            tempTable.setYokinShubetsuCode(口座.get預金種別().get預金種別コード());
            tempTable.setYokinShubetsuName(口座.get預金種別().get預金種別略称());
        }
        tempTable.setKozaNo(口座.get口座番号());
        tempTable.setKozaMeiginin(口座.get口座名義人());
        tempTable.setKozaMeigininKanji(口座.get口座名義人漢字());

    }

    private void setTempTableEditorKoza(EditedKoza editorKoza, FurikomiDetailTempTableEntity tempTable) {
        tempTable.setKinyuKikanShitenCode(new KinyuKikanShitenCode(editorKoza.get振込支店コード()));
        tempTable.setKinyuKikanShitenName(editorKoza.get振込支店名());
        tempTable.setKinyuKikanShitenKanaName(editorKoza.get振込支店カナ名());

    }

    private RString set口座名寄せキー(IKoza 口座, EditedKoza editorKoza, FurikomiDetailTempTableEntity tempTable) {
        金融機関コード = (口座.get金融機関コード() == null || 口座.get金融機関コード().isEmpty()) ? ゼロ4
                : 口座.get金融機関コード().value().padLeft("0", INT4);
        口座番号 = (口座.get口座番号() == null || 口座.get口座番号().isEmpty()) ? ゼロ7 : 口座.get口座番号().padLeft("0", INT7);
        if (口座.get預金種別() != null) {
            預金種別コード = (口座.get預金種別().get預金種別コード() == null || 口座.get預金種別().get預金種別コード().isEmpty())
                    ? ゼロ1 : 口座.get預金種別().get預金種別コード().padLeft("0", INT1);
        } else {
            預金種別コード = ゼロ1;
        }
        支店コード = (editorKoza.get振込支店コード() == null || editorKoza.get振込支店コード().isEmpty()) ? ゼロ3
                : editorKoza.get振込支店コード().padLeft("0", INT3);
        set名寄せ(tempTable, 金融機関コード, 支店コード, 預金種別コード, 口座番号);
        return 口座名寄せキー;
    }

    private RString set口座名寄せキー2(DbT3077JuryoininKeiyakuJigyoshaEntity dbt3077Entity, FurikomiDetailTempTableEntity tempTable) {
        if (dbt3077Entity != null) {
            KinyuKikanCode kinyuKikan = dbt3077Entity.getKinyuKikanCode();
            if (kinyuKikan != null && !kinyuKikan.isEmpty()) {
                金融機関コード = kinyuKikan.value().padLeft(INT4);
            }
            KinyuKikanShitenCode shiten = dbt3077Entity.getShitenCode();
            if (shiten != null && !shiten.isEmpty()) {
                支店コード = shiten.value().padLeft(INT3);
            }
            RString shubetsu = dbt3077Entity.getKozaShubetsu();
            if (shubetsu != null && !shubetsu.isEmpty()) {
                預金種別コード = shubetsu.padLeft(INT1);
            }
            RString kozaNo = dbt3077Entity.getKozaNo();
            if (kozaNo != null && !kozaNo.isEmpty()) {
                口座番号 = kozaNo.padLeft(INT7);
            }
        } else {
            金融機関コード = ゼロ4;
            支店コード = ゼロ3;
            預金種別コード = ゼロ1;
            口座番号 = ゼロ7;
        }
        set名寄せ(tempTable, 金融機関コード, 支店コード, 預金種別コード, 口座番号);
        return 口座名寄せキー;
    }

    private void set名寄せ(FurikomiDetailTempTableEntity tempTable, RString 金融機関コード, RString 支店コード,
            RString 預金種別コード, RString 口座番号) {
        被保険者番号 = (tempTable.getHihokenshaNo() == null || tempTable.getHihokenshaNo().isEmpty()) ? ゼロ10
                : tempTable.getHihokenshaNo().value().padLeft("0", INT10);
        サービス提供年月 = (tempTable.getServiceTeikyoYM() == null || tempTable.getServiceTeikyoYM().isEmpty())
                ? ゼロ6 : tempTable.getServiceTeikyoYM().toDateString().padLeft("0", INT6);
        整理番号 = (tempTable.getSeiriNo() == null || tempTable.getSeiriNo().isEmpty()) ? ゼロ10
                : tempTable.getSeiriNo().padLeft("0", INT10);
        履歴番号 = new RString(tempTable.getRirekiNo()).padLeft("0", INT4);
        RString sakiEncodeKeitai = DbBusinessConfig.get(ConfigNameDBC.名寄せ, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        if (KozaNayoseHoho.被保険者毎に同一口座で名寄せする.getコード().equals(sakiEncodeKeitai)) {
            口座名寄せキー = 金融機関コード.concat(支店コード).concat(預金種別コード).concat(口座番号).concat(被保険者番号);
        } else if (KozaNayoseHoho.同一口座で名寄せする.getコード().equals(sakiEncodeKeitai)) {
            口座名寄せキー = 金融機関コード.concat(支店コード).concat(預金種別コード).concat(口座番号);
        } else {
            口座名寄せキー = 被保険者番号.concat(サービス提供年月).concat(整理番号).concat(履歴番号);
        }
    }

}
