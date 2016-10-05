/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 給付管理票一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity {

    private int 連番;
    private HihokenshaNo 被保険者番号;
    private RString 対象年度;
    private HokenshaNo 保険者番号;
    private RString 支給申請書整理番号;
    private int 履歴番号;
    private RString 自己負担額証明書整理番号;
    private RString 保険制度コード;
    private RString 被保険者証記号;
    private RString 対象計算期間開始年月日;
    private RString 対象計算期間終了年月日;
    private RString 申請年月日;
    private RString 決定年月日;
    private Decimal 自己負担総額;
    private RString 支給区分コード;
    private Decimal 支給額;
    private RString 給付の種類;
    private RString 不支給理由;
    private RString 備考;
    private RString 支払方法区分;
    private RString 支払場所;
    private RString 支払期間開始年月日;
    private RString 支払期間終了年月日;
    private RString 支払期間開始時間;
    private RString 支払期間終了時間;
    private RString 金融機関コード;
    private RString 金融機関名;
    private RString 金融機関支店コード;
    private RString 金融機関支店名;
    private RString 口座種目;
    private RString 口座種目名;
    private RString 口座番号;
    private RString 口座名義人_カナ;
    private Long 口座ID;
    private RString 帳票関連付け番号;

    /**
     * DbWT38B1KogakuGassanShikyuFushikyuKetteiEntityにかわる。
     *
     * @return DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity
     */
    public DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity toEntity() {
        DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity entity = new DbWT38B1KogakuGassanShikyuFushikyuKetteiEntity();
        entity.setRenban(連番);
        entity.setHihokenshaNoIn(被保険者番号);
        entity.setTaishoNendo(対象年度);
        entity.setShoKisaiHokenshaNo(保険者番号);
        entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        entity.setRirekiNo(履歴番号);
        entity.setJikoFutanSeiriNo(自己負担額証明書整理番号);
        entity.setHokenSeidoCode(保険制度コード);
        entity.setKokuho_HihokenshaShoKigo(被保険者証記号);
        entity.setKeisanKaishiYMD(対象計算期間開始年月日);
        entity.setKeisanShuryoYMD(対象計算期間終了年月日);
        entity.setShinseiYMD(申請年月日);
        entity.setKetteiYMD(決定年月日);
        entity.setJikoFutanSogaku(自己負担総額);
        entity.setShikyuKubunCode(支給区分コード);
        entity.setShikyugaku(支給額);
        entity.setKyufuShurui(給付の種類);
        entity.setFushikyuRiyu(不支給理由);
        entity.setBiko(備考);
        entity.setShiharaiHohoKubun(支払方法区分);
        entity.setShiharaiBasho(支払場所);
        entity.setShiharaiKaishiYMD(支払期間開始年月日);
        entity.setShiharaiShuryoYMD(支払期間終了年月日);
        entity.setShiharaiKaishiTime(支払期間開始時間);
        entity.setShiharaiShuryoTime(支払期間終了時間);
        entity.setKinyuKikanCode(金融機関コード);
        entity.setKinyuKikanMei(金融機関名);
        entity.setKinyuKikanShitenCode(金融機関支店コード);
        entity.setKinyuKikanShitenMei(金融機関支店名);
        entity.setKozaShumoku(口座種目);
        entity.setKozaShumokuMei(口座種目名);
        entity.setKozaNo(口座番号);
        entity.setKozaMeiginin(口座名義人_カナ);
        entity.setKozaID(口座ID);
        entity.setChohyoKanrenzukeNo(帳票関連付け番号);
        return entity;
    }
}
