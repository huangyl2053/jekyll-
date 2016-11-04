/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakokanribocsvdatasakusei;

import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakoKanriboCsvDataSakuseiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 被保険者証発行管理簿_CSVデータ作成のクラスです。
 *
 * @reamsid_L DBA-0600-040 zhangguopeng
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihohenshashoHakoKanriboCsvDataSakusei {

    /**
     * 証発行管理CSVデータリスト作成します。
     *
     * @param entity 証発行管理情報
     * @param koumukumeyifukaflg 項目名付加フラグ
     * @param hizikehensyuuflg 日付'/'編集フラグ
     * @return 証発行管理リストCSV用データ
     */
    public HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity getShohakkoKanriCSVDataList(
            AkasiHakouKanriEntity entity, boolean koumukumeyifukaflg, boolean hizikehensyuuflg) {
        HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity csvEntity = new HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity();
        csvEntity.setHihokenshaNo(entity.getHihokenshaNo());
        csvEntity.setShikibetsuCode(entity.getShikibetsuCode().value());
        csvEntity.setShichosonCode(entity.getShichosonCode().value());
        csvEntity.setKofuJiyuCode(entity.getKofuJiyuCode().value());
        csvEntity.setKofuJiyuRyakusho(entity.getKofuJiyuRyakusho());
        csvEntity.setKofuJiyu(entity.getKofuJiyu());
        csvEntity.setKaishuJiyuCode(entity.getKaishuJiyuCode().value());
        csvEntity.setKaishuJiyu(entity.getKofuJiyu());
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            YubinNo 郵便番号 = 宛名Entity.getYubinNo();
            AtenaJusho 住所 = 宛名Entity.getJusho();
            AtenaMeisho 氏名 = 宛名Entity.getMeisho();
            csvEntity.setYubinNo(郵便番号 != null ? 郵便番号.value() : RString.EMPTY);
            csvEntity.setJusho(住所 != null ? 住所.value() : RString.EMPTY);
            csvEntity.setMeisho(氏名 != null ? 氏名.value() : RString.EMPTY);
        }
        if (hizikehensyuuflg) {
            csvEntity.setKofuYMD(entity.getKofuYMD() == null ? RString.EMPTY : entity.getKofuYMD().seireki().separator(
                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
            csvEntity.setKaishuYMD(entity.getKaishuYMD() == null ? RString.EMPTY : entity.getKaishuYMD().seireki().separator(
                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
            csvEntity.setYukoKigenYMD(entity.getYukoKigenYMD() == null ? RString.EMPTY : entity.getYukoKigenYMD().seireki().separator(
                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
        } else {
            csvEntity.setKofuYMD(entity.getKofuYMD() == null ? RString.EMPTY : entity.getKofuYMD().seireki().separator(
                    Separator.NONE).fillType(FillType.ZERO).toDateString());
            csvEntity.setKaishuYMD(entity.getKaishuYMD() == null ? RString.EMPTY : entity.getKaishuYMD().seireki().separator(
                    Separator.NONE).fillType(FillType.ZERO).toDateString());
            csvEntity.setYukoKigenYMD(entity.getYukoKigenYMD() == null ? RString.EMPTY : entity.getYukoKigenYMD().seireki().separator(
                    Separator.NONE).fillType(FillType.ZERO).toDateString());
        }
        csvEntity.setShoYoshikiKubunCode(entity.getShoYoshikiKubunCode());
        return csvEntity;
    }

    /**
     * 証発行管理CSVデータリスト作成(連番有)します。
     *
     * @param entity 証発行管理情報
     * @param koumukumeyifukaflg 項目名付加フラグ
     * @param hizikehensyuuflg 日付'/'編集フラグ
     * @param renban 連番
     * @return 証発行管理リストCSV用データ(連番有)
     */
    public HihohenshashoHakoKanriboCsvDataSakuseiEntity getShohakkoKanriCSVDataListAddRenban(
            AkasiHakouKanriEntity entity,
            boolean koumukumeyifukaflg,
            boolean hizikehensyuuflg,
            int renban) {
        HihohenshashoHakoKanriboCsvDataSakuseiEntity csvEntity = new HihohenshashoHakoKanriboCsvDataSakuseiEntity();
        csvEntity.setHihokenshaNo(entity.getHihokenshaNo());
        csvEntity.setShikibetsuCode(entity.getShikibetsuCode().value());
        csvEntity.setShichosonCode(entity.getShichosonCode().value());
        csvEntity.setKofuJiyuCode(entity.getKofuJiyuCode().value());
        csvEntity.setKofuJiyuRyakusho(entity.getKofuJiyuRyakusho());
        csvEntity.setKofuJiyu(entity.getKofuJiyu());
        csvEntity.setKaishuJiyuCode(entity.getKaishuJiyuCode().value());
        csvEntity.setKaishuJiyu(entity.getKofuJiyu());
        UaFt200FindShikibetsuTaishoEntity 宛名Entity = entity.get宛名Entity();
        if (宛名Entity != null) {
            YubinNo 郵便番号 = 宛名Entity.getYubinNo();
            AtenaJusho 住所 = 宛名Entity.getJusho();
            AtenaMeisho 氏名 = 宛名Entity.getMeisho();
            csvEntity.setYubinNo(郵便番号 != null ? 郵便番号.value() : RString.EMPTY);
            csvEntity.setJusho(住所 != null ? 住所.value() : RString.EMPTY);
            csvEntity.setMeisho(氏名 != null ? 氏名.value() : RString.EMPTY);
        }
        if (hizikehensyuuflg) {
            csvEntity.setKofuYMD(entity.getKofuYMD() == null ? RString.EMPTY : entity.getKofuYMD().seireki().separator(
                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
            csvEntity.setKaishuYMD(entity.getKaishuYMD() == null ? RString.EMPTY : entity.getKaishuYMD().seireki().separator(
                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
            csvEntity.setYukoKigenYMD(entity.getYukoKigenYMD() == null ? RString.EMPTY : entity.getYukoKigenYMD().seireki().separator(
                    Separator.SLASH).fillType(FillType.ZERO).toDateString());
        } else {
            csvEntity.setKofuYMD(entity.getKofuYMD() == null ? RString.EMPTY : entity.getKofuYMD().seireki().separator(
                    Separator.NONE).fillType(FillType.ZERO).toDateString());
            csvEntity.setKaishuYMD(entity.getKaishuYMD() == null ? RString.EMPTY : entity.getKaishuYMD().seireki().separator(
                    Separator.NONE).fillType(FillType.ZERO).toDateString());
            csvEntity.setYukoKigenYMD(entity.getYukoKigenYMD() == null ? RString.EMPTY : entity.getYukoKigenYMD().seireki().separator(
                    Separator.NONE).fillType(FillType.ZERO).toDateString());
        }
        csvEntity.setShoYoshikiKubunCode(entity.getShoYoshikiKubunCode());
        csvEntity.setRenban(renban);
        return csvEntity;
    }
}
