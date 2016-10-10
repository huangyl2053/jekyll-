/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.shikakushutokushafuseigo;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.HihokenshaJoho;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakuShutokushaFuseigoEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranCsvDataEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.shikakushutokushafuseigoichiranhyo.ShikakushutokushaFuseigoIchiranhyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 資格取得者不整合リストのデータ処理クラスです。
 *
 * @reamsid_L DBU-4020-030 lishengli
 */
public class ShikakuShutokushaFuseigoListHenSyu {

    private static final RString 住所地特例フラグ = new RString("1");
    private static final RString 資格重複者 = new RString("01");

    /**
     * 資格取得者不整合リスト帳票用データの取得処理。
     *
     * @param entity 資格取得者不整合リストEntity
     * @return ShikakushutokushaFuseigoIchiranhyoEntity
     */
    public ShikakushutokushaFuseigoIchiranhyoEntity get資格取得者不整合リスト帳票用データ(ShikakuShutokushaFuseigoEntity entity) {
        ShikakushutokushaFuseigoIchiranhyoEntity ichiranhyoEntity = new ShikakushutokushaFuseigoIchiranhyoEntity();
        ichiranhyoEntity.setタイトル(new RString("介護保険　資格取得者不整合一覧表"));
        RDate システム日時 = RDate.getNowDate();
        ichiranhyoEntity.set市町村コード(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, システム日時, SubGyomuCode.DBU介護統計報告));
        ichiranhyoEntity.set市町村名称(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称, システム日時, SubGyomuCode.DBU介護統計報告));
        if (entity.getHihokenshaNo() != null && !entity.getHihokenshaNo().isEmpty()) {
            ichiranhyoEntity.set被保険者番号(entity.getHihokenshaNo().value());
        }
        if (entity.getKanaMeisho() != null && !entity.getKanaMeisho().isEmpty()) {
            ichiranhyoEntity.setﾌﾘｶﾞﾅ(entity.getKanaMeisho().value());
        }
        if (entity.getMeisho() != null && !entity.getMeisho().isEmpty()) {
            ichiranhyoEntity.set氏名(entity.getMeisho().value());
        }
        if (entity.getShikibetsuCode() != null && !entity.getShikibetsuCode().isEmpty()) {
            ichiranhyoEntity.set識別コード(entity.getShikibetsuCode().value());
        }
        ichiranhyoEntity.set生年月日(entity.getSeinengappiYMD());
        ichiranhyoEntity.set前住所(get住所(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()));
        ichiranhyoEntity.set現住所(get住所(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()));
        if (entity.getShichosonCode() != null && !entity.getShichosonCode().isEmpty()) {
            ichiranhyoEntity.set市町村コードList(entity.getShichosonCode().value());
        }
        ichiranhyoEntity.set資格区分(get被保険者情報(entity.getHihokennshaKubunCode()));
        if (住所地特例フラグ.equals(entity.getJushochiTokureiFlag())) {
            ichiranhyoEntity.set住特(new RString("*"));
        } else {
            ichiranhyoEntity.set住特(RString.EMPTY);
        }
        if (資格重複者.equals(entity.get不整合情報())) {
            ichiranhyoEntity.set不整合情報(new RString("資格重複者"));
        } else {
            ichiranhyoEntity.set不整合情報(new RString("不整合データ"));
        }
        return ichiranhyoEntity;
    }

    /**
     * 資格取得者不整合リストCSV用データの取得処理。
     *
     * @param entity 資格取得者不整合リストEntity
     * @param 連番 連番
     * @return ShikakushutokushaFuseigoIchiranCsvDataEntity
     */
    public ShikakushutokushaFuseigoIchiranCsvDataEntity get資格取得者不整合リストCSV用データ(ShikakuShutokushaFuseigoEntity entity, int 連番) {
        ShikakushutokushaFuseigoIchiranCsvDataEntity csvDataEntity = new ShikakushutokushaFuseigoIchiranCsvDataEntity();
        csvDataEntity.setRenban(連番);
        if (entity.getHihokenshaNo() != null && !entity.getHihokenshaNo().isEmpty()) {
            csvDataEntity.setHihokenshaNo(entity.getHihokenshaNo().value());
        }
        if (entity.getKanaMeisho() != null && !entity.getKanaMeisho().isEmpty()) {
            csvDataEntity.setArigana(entity.getKanaMeisho().value());
        }
        if (entity.getMeisho() != null && !entity.getMeisho().isEmpty()) {
            csvDataEntity.setMeisho(entity.getMeisho().value());
        }
        if (entity.getShikibetsuCode() != null && !entity.getShikibetsuCode().isEmpty()) {
            csvDataEntity.setShikibetsuCode(entity.getShikibetsuCode().value());
        }
        csvDataEntity.setSeneYMD(get生年月日(entity.getSeinengappiYMD()));
        csvDataEntity.setZjusho(get住所(entity.getTennyumaeJusho(), entity.getTennyumaeBanchi(), entity.getTennyumaeKatagaki()));
        csvDataEntity.setJusho(get住所(entity.getJusho(), entity.getBanchi(), entity.getKatagaki()));
        if (entity.getShichosonCode() != null && !entity.getShichosonCode().isEmpty()) {
            csvDataEntity.setShichosonCode(entity.getShichosonCode().value());
        }
        csvDataEntity.setShikaKubun(get被保険者情報(entity.getHihokennshaKubunCode()));
        if (住所地特例フラグ.equals(entity.getJushochiTokureiFlag())) {
            csvDataEntity.setJuutoku(new RString("*"));
        } else {
            csvDataEntity.setJuutoku(RString.EMPTY);
        }
        if (資格重複者.equals(entity.get不整合情報())) {
            csvDataEntity.setFuseigoJyou(new RString("資格重複者"));
        } else {
            csvDataEntity.setFuseigoJyou(new RString("不整合データ"));
        }
        return csvDataEntity;
    }

    private RString get生年月日(FlexibleDate 生年月日) {
        if (生年月日 != null && !生年月日.isEmpty()) {
            return 生年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get住所(AtenaJusho 住所, AtenaBanchi 番地, Katagaki 方書) {
        RStringBuilder 前住所 = new RStringBuilder();
        if (住所 != null && !住所.isEmpty()) {
            前住所.append(住所.value());
        }
        if (番地 != null && !番地.isEmpty()) {
            前住所.append(番地.value());
        }
        if (方書 != null && !方書.isEmpty()) {
            前住所.append(方書.value());
        }
        return 前住所.toRString();
    }

    private RString get被保険者情報(RString code) {
        if (!RString.isNullOrEmpty(code)) {
            HihokenshaJoho.toValue(code).get名称();
        }
        return RString.EMPTY;
    }
}
