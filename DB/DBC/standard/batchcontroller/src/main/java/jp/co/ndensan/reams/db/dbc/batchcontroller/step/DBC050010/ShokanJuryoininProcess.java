/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.KozaNayoseHoho;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050010.KozaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.ShokanJuryoininEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikan;
import jp.co.ndensan.reams.ua.uax.business.core.kinyukikan.KinyuKikanShiten;
import jp.co.ndensan.reams.ua.uax.business.core.koza.YokinShubetsuPattern;
import jp.co.ndensan.reams.ua.uax.service.core.kinyukikan.KinyuKikanManager;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還受領委任払の口座情報取得_Process処理クラスです．
 *
 * @reamsid_L DBC-2180-030 donghj
 */
public class ShokanJuryoininProcess extends BatchProcessBase<ShokanJuryoininEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IShokanJuryoininMapper.get償還受領委任払の口座情報");
    private KozaJohoProcessParameter parameter;
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
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @BatchWriter
    BatchEntityCreatedTempTableWriter furikomiDetailTempTable;

    @Override
    protected void createWriter() {
        furikomiDetailTempTable = BatchEntityCreatedTempTableWriterBuilders.createBuilder(FurikomiDetailTempTableEntity.class)
                .tempTableName(FurikomiDetailTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(ShokanJuryoininEntity entity) {
        FurikomiDetailTempTableEntity tempTable = entity.get振込明細一時Entity();
        FlexibleDate 振込指定年月日 = new FlexibleDate(RDate.getNowDate().toDateString());
        if (parameter.get振込指定年月日() != null) {
            振込指定年月日 = new FlexibleDate(parameter.get振込指定年月日().toDateString());
        }
        KinyuKikanManager kinyuKikanManager = KinyuKikanManager.createInstance();
        KinyuKikan 金融機関情報 = null;
        DbT3077JuryoininKeiyakuJigyoshaEntity dbt3077Entity = entity.get受領委任契約事業者Entity();
        if (dbt3077Entity != null) {
            KinyuKikanCode kinyuKikanCode = dbt3077Entity.getKinyuKikanCode();
            if (kinyuKikanCode != null && !kinyuKikanCode.isEmpty()) {
                金融機関情報 = kinyuKikanManager.getValidKinyuKikanOn(振込指定年月日, kinyuKikanCode.value());
            }
            setTempTable2(dbt3077Entity, 金融機関情報, tempTable);
        }
        tempTable.setKozaDataFlag(true);
        tempTable.setKozaShikibetsuCode(ShikibetsuCode.EMPTY);
        tempTable.setKozaNayoseKey(set口座名寄せキー2(dbt3077Entity, tempTable));
        furikomiDetailTempTable.update(tempTable);
    }

    private void setTempTable2(DbT3077JuryoininKeiyakuJigyoshaEntity dbt3077Entity, KinyuKikan 金融機関情報,
            FurikomiDetailTempTableEntity tempTable) {

        tempTable.setKinyuKikanCode(dbt3077Entity.getKinyuKikanCode());
        KinyuKikanShitenCode shitenCode = dbt3077Entity.getShitenCode();
        RString 口座種別 = dbt3077Entity.getKozaShubetsu();
        YokinShubetsuPattern 預金種別 = null;
        if (金融機関情報 != null) {
            tempTable.setKinyuKikanName(金融機関情報.get金融機関名称());
            tempTable.setKinyuKikanKanaName(金融機関情報.get金融機関カナ名称());
            if (shitenCode != null && !shitenCode.isEmpty()) {
                tempTable.setKinyuKikanShitenCode(shitenCode);
                set支店(金融機関情報, tempTable, shitenCode);
            }
            if (口座種別 != null && !口座種別.isEmpty()) {
                預金種別 = 金融機関情報.get預金種別(口座種別);
            }
        }
        if (預金種別 != null) {
            tempTable.setYokinShubetsuName(預金種別.get預金種別略称());
        }
        tempTable.setYokinShubetsuCode(口座種別);
        tempTable.setKozaNo(dbt3077Entity.getKozaNo());
        tempTable.setKozaMeiginin(dbt3077Entity.getKozaMeigininKana());
        tempTable.setKozaMeigininKanji(dbt3077Entity.getKozaMeiginin());

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
