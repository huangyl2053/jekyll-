/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshohoshuseikyu;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.hoshushiharaijunbi.HoshuShiharaiJunbiRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshohoshuseikyu.IkenshoHoshuSeikyuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;
import lombok.Getter;
import lombok.Setter;

/**
 * 主治医意見書作成報酬請求書のEditクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IkenshoHoshuSeikyuEdit {

    private int index;
    private RString shujiiIryokikanCode = RString.EMPTY;

    /**
     * 主治医意見書作成報酬請求書の編集処理です。
     *
     * @param entity 主治医意見書作成報酬請求書
     * @param 消費税率 消費税率
     * @return IkenshoHoshuSeikyuEntity
     */
    public IkenshoHoshuSeikyuEntity getIkenshoHoshuSeikyuEntity(HoshuShiharaiJunbiRelateEntity entity, RString 消費税率) {
        IkenshoHoshuSeikyuEntity seikyuEntity = new IkenshoHoshuSeikyuEntity();
        seikyuEntity.set郵便番号(entity.getYubinNo());
        seikyuEntity.set住所(entity.getJusho());
        seikyuEntity.set医療機関(entity.getIryoKikanMeisho());
        seikyuEntity.set代表者名(entity.getDaihyoshaName());
        seikyuEntity.set帳票タイトル(DbBusinessConfig.get(ConfigNameDBE.主治医意見書作成報酬請求書, RDate.getNowDate(),
                SubGyomuCode.DBE認定支援));
        if (!shujiiIryokikanCode.equals(entity.getShujiiIryoKikanCode())) {
            index = 1;
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set新規在宅件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set新規在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("2").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set新規施設件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set新規施設単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set更新在宅件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set更新在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("2").equals(entity.getZaitakuShisetsuKubun())) {
                seikyuEntity.set更新施設件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set更新施設単価(kinngakuFormat(entity.getTanka()));
            }
        }
        getIkenshoHoshuSeikyuEntity(entity, seikyuEntity);
        shujiiIryokikanCode = entity.getShujiiIryoKikanCode();
        int 新規在宅計 = 0;
        int 新規施設計 = 0;
        int 更新在宅計 = 0;
        int 更新施設計 = 0;
        if (entity.getTanka() != null) {
            新規在宅計 = Integer.valueOf(seikyuEntity.get新規在宅件数().toString()) * Integer.valueOf(entity.getTanka().toString());
            新規施設計 = Integer.valueOf(seikyuEntity.get新規施設件数().toString()) * Integer.valueOf(entity.getTanka().toString());
            更新在宅計 = Integer.valueOf(seikyuEntity.get更新在宅件数().toString()) * Integer.valueOf(entity.getTanka().toString());
            更新施設計 = Integer.valueOf(seikyuEntity.get更新施設件数().toString()) * Integer.valueOf(entity.getTanka().toString());
        }
        seikyuEntity.set新規在宅計(kinngakuFormat(new Decimal(新規在宅計)));
        seikyuEntity.set新規施設計(kinngakuFormat(new Decimal(新規施設計)));
        seikyuEntity.set更新在宅計(kinngakuFormat(new Decimal(更新在宅計)));
        seikyuEntity.set更新施設計(kinngakuFormat(new Decimal(更新施設計)));
        int 作成件数合計 = Integer.valueOf(seikyuEntity.get新規在宅件数().toString()) + Integer.valueOf(seikyuEntity.get新規施設件数().toString())
                + Integer.valueOf(seikyuEntity.get更新在宅件数().toString()) + Integer.valueOf(seikyuEntity.get更新施設件数().toString());
        int 小計 = 新規在宅計 + 新規施設計 + 更新在宅計 + 更新施設計;
        seikyuEntity.set更新施設計(kinngakuFormat(new Decimal(作成件数合計)));
        seikyuEntity.set小計(kinngakuFormat(new Decimal(小計)));
        int 消費税額 = 小計 * Integer.valueOf(消費税率.toString()) - 小計;
        seikyuEntity.set消費税額(kinngakuFormat(new Decimal(消費税額)));
        int 合計金額 = 小計 + 消費税額;
        seikyuEntity.set合計金額(kinngakuFormat(new Decimal(合計金額)));
        seikyuEntity.set請求金額(kinngakuFormat(new Decimal(合計金額)));
        return seikyuEntity;
    }

    private IkenshoHoshuSeikyuEntity getIkenshoHoshuSeikyuEntity(HoshuShiharaiJunbiRelateEntity entity, IkenshoHoshuSeikyuEntity seikyuEntity) {
        if (shujiiIryokikanCode.equals(entity.getShinsakaiIinCode())) {
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set新規在宅件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set新規在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("1").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("2").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set新規施設件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set新規施設単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("1").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set更新在宅件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set更新在宅単価(kinngakuFormat(entity.getTanka()));
            }
            if (new Code("2").equals(entity.getIkenshoSakuseiKaisuKubun()) && new Code("2").equals(entity.getZaitakuShisetsuKubun())) {
                index++;
                seikyuEntity.set更新施設件数(kinngakuFormat(new Decimal(index)));
                seikyuEntity.set更新施設単価(kinngakuFormat(entity.getTanka()));
            }
        }
        return seikyuEntity;
    }

    private RString kinngakuFormat(Decimal date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(date, 0);
    }
}
