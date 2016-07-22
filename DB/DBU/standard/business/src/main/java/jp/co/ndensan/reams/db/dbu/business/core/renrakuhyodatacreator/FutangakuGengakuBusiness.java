/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.renrakuhyodatacreator;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護保険連絡票作成のBusinessクラスです。
 *
 * @reamsid_L DBA-1290-020 linghuhang
 */
public class FutangakuGengakuBusiness {

    private final DbT4018KaigoHokenFutanGendogakuNinteiEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity FutangakuGengakuRelateEntity
     */
    public FutangakuGengakuBusiness(DbT4018KaigoHokenFutanGendogakuNinteiEntity entity) {
        this.entity = entity;
    }

    /**
     * 申請年月日を取得します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 決定年月日を取得します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 適用開始年月日を取得します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を取得します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 決定区分を取得します。
     *
     * @return 決定区分
     */
    public RString get決定区分() {
        return entity.getKetteiKubun();
    }

    /**
     * 非承認理由を取得します。
     *
     * @return 非承認理由
     */
    public RString get非承認理由() {
        return entity.getHiShoninRiyu();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 履歴番号を取得します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 旧措置者区分を取得します。
     *
     * @return 旧措置者区分
     */
    public RString get旧措置者区分() {
        if (RString.isNullOrEmpty(entity.getKyusochishaKubun())) {
            return new RString("0");
        }
        return entity.getKyusochishaKubun();
    }

    /**
     * 申請理由区分を取得します。
     *
     * @return 申請理由区分
     */
    public RString get申請理由区分() {
        return entity.getShinseiRiyuKubun();
    }

    /**
     * 利用者負担段階を取得します。
     *
     * @return 利用者負担段階
     */
    public RString get利用者負担段階() {
        return entity.getRiyoshaFutanDankai();
    }

    /**
     * 境界層該当者区分を取得します。
     *
     * @return 境界層該当者区分
     */
    public boolean is境界層該当者区分() {
        return entity.getKyokaisoGaitoshaKubun();
    }

    /**
     * 激変緩和措置対象者区分を取得します。
     *
     * @return 激変緩和措置対象者区分
     */
    public boolean is激変緩和措置対象者区分() {
        return entity.getGekihenKanwaSochiTaishoshaKubun();
    }

    /**
     * 居室種別を取得します。
     *
     * @return 居室種別
     */
    public RString get居室種別() {
        return entity.getKyoshitsuShubetsu();
    }

    /**
     * 食費負担限度額を取得します。
     *
     * @return 食費負担限度額
     */
    public Decimal get食費負担限度額() {
        return entity.getShokuhiFutanGendogaku();
    }

    /**
     * ユニット型個室を取得します。
     *
     * @return ユニット型個室
     */
    public Decimal getユニット型個室() {
        return entity.getUnitTypeKoshitsu();
    }

    /**
     * ユニット型準個室を取得します。
     *
     * @return ユニット型準個室
     */
    public Decimal getユニット型準個室() {
        return entity.getUnitTypeJunKoshitsu();
    }

    /**
     * 従来型個室_特養等を取得します。
     *
     * @return 従来型個室_特養等
     */
    public Decimal get従来型個室_特養等() {
        return entity.getJuraiTypeKoshitsu_Tokuyo();
    }

    /**
     * 従来型個室_老健_療養などを取得します。
     *
     * @return 従来型個室_老健_療養など
     */
    public Decimal get従来型個室_老健_療養など() {
        return entity.getJuraiTypeKoshitsu_Roken_Ryoyo();
    }

    /**
     * 多床室を取得します。
     *
     * @return 多床室
     */
    public Decimal get多床室() {
        return entity.getTashoshitsu();
    }
}
