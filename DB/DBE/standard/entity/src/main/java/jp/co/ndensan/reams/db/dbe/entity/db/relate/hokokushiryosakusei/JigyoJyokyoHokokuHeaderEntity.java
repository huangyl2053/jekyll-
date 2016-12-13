/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.hokokushiryosakusei;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 要介護認定事業状況報告の情報です。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
@OnNextSchema("rgdb")
public class JigyoJyokyoHokokuHeaderEntity extends DbTableEntityBase<JigyoJyokyoHokokuHeaderEntity> implements IDbAccessable {

    /**
     * 被保険者情報（一時テーブル）
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("JigyoJyokyoHokokuTemp"));
    }
    @TempTableColumnOrder(1)
    private FlexibleYearMonth nijiHanteiYM;
    @TempTableColumnOrder(2)
    private Code nijiHanteiYokaigoJotaiKubunCode;
    @TempTableColumnOrder(3)
    private RString hihokenshaKubunCode;
    @TempTableColumnOrder(4)
    private int age;
    @TempTableColumnOrder(5)
    private RString shoKisaiHokenshaNo;
    @TempTableColumnOrder(6)
    private Code ninteiShinseiShinseijiKubunCode;
    @TempTableColumnOrder(7)
    private Code ninteiShinseiHoreiKubunCode;
    @TempTableColumnOrder(8)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(9)
    private RString shichosonMeisho;
    @TempTableColumnOrder(10)
    private RString hihokenshaNo;

    /**
     * 二次判定年月のgetメソッドです。
     *
     * @return the nijiHanteiYM
     */
    public FlexibleYearMonth getNijiHanteiYM() {
        return nijiHanteiYM;
    }

    /**
     * 二次判定年月のsetメソッドです。
     *
     * @param nijiHanteiYM the nijiHanteiYM to set
     */
    public void setNijiHanteiYM(FlexibleYearMonth nijiHanteiYM) {
        this.nijiHanteiYM = nijiHanteiYM;
    }

    /**
     * 二次判定要介護状態区分コードのgetメソッドです。
     *
     * @return the nijiHanteiYokaigoJotaiKubunCode
     */
    public Code getNijiHanteiYokaigoJotaiKubunCode() {
        return nijiHanteiYokaigoJotaiKubunCode;
    }

    /**
     * 二次判定要介護状態区分コードのsetメソッドです。
     *
     * @param nijiHanteiYokaigoJotaiKubunCode the
     * nijiHanteiYokaigoJotaiKubunCode to set
     */
    public void setNijiHanteiYokaigoJotaiKubunCode(Code nijiHanteiYokaigoJotaiKubunCode) {
        this.nijiHanteiYokaigoJotaiKubunCode = nijiHanteiYokaigoJotaiKubunCode;
    }

    /**
     * 被保険者区分コードのgetメソッドです。
     *
     * @return the hihokenshaKubunCode
     */
    public RString getHihokenshaKubunCode() {
        return hihokenshaKubunCode;
    }

    /**
     * 被保険者区分コードのsetメソッドです。
     *
     * @param hihokenshaKubunCode the hihokenshaKubunCode to set
     */
    public void setHihokenshaKubunCode(RString hihokenshaKubunCode) {
        this.hihokenshaKubunCode = hihokenshaKubunCode;
    }

    /**
     * 年齢のgetメソッドです。
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * 年齢のsetメソッドです。
     *
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return the shoKisaiHokenshaNo
     */
    public RString getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo the shoKisaiHokenshaNo to set
     */
    public void setShoKisaiHokenshaNo(RString shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 認定申請区分(申請時)コードのgetメソッドです。
     *
     * @return the ninteiShinseiShinseijiKubunCode
     */
    public Code getNinteiShinseiShinseijiKubunCode() {
        return ninteiShinseiShinseijiKubunCode;
    }

    /**
     * 認定申請区分(申請時)コードのsetメソッドです。
     *
     * @param ninteiShinseiShinseijiKubunCode the
     * ninteiShinseiShinseijiKubunCode to set
     */
    public void setNinteiShinseiShinseijiKubunCode(Code ninteiShinseiShinseijiKubunCode) {
        this.ninteiShinseiShinseijiKubunCode = ninteiShinseiShinseijiKubunCode;
    }

    /**
     * 市町村コードのgetメソッドです。
     *
     * @return the shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     *
     * @param shichosonCode the shichosonCode to set
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 市町村名称のgetメソッドです。
     *
     * @return the shichosonMeisho
     */
    public RString getShichosonMeisho() {
        return shichosonMeisho;
    }

    /**
     * 市町村名称のsetメソッドです。
     *
     * @param shichosonMeisho the shichosonMeisho to set
     */
    public void setShichosonMeisho(RString shichosonMeisho) {
        this.shichosonMeisho = shichosonMeisho;
    }

    /**
     * 認定申請区分(法令)コードのgetメソッドです。
     *
     * @return the ninteiShinseiHoreiKubunCode
     */
    public Code getNinteiShinseiHoreiKubunCode() {
        return ninteiShinseiHoreiKubunCode;
    }

    /**
     * 認定申請区分(法令)コードのsetメソッドです。
     *
     * @param ninteiShinseiHoreiKubunCode the ninteiShinseiHoreiKubunCode to set
     */
    public void setNinteiShinseiHoreiKubunCode(Code ninteiShinseiHoreiKubunCode) {
        this.ninteiShinseiHoreiKubunCode = ninteiShinseiHoreiKubunCode;
    }
    
    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return the ninteiShinseiHoreiKubunCode
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo the hihokenshaNo to set
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(JigyoJyokyoHokokuHeaderEntity entity) {
        this.setNijiHanteiYM(entity.getNijiHanteiYM());
        this.setNijiHanteiYokaigoJotaiKubunCode(entity.getNijiHanteiYokaigoJotaiKubunCode());
        this.setHihokenshaKubunCode(entity.getHihokenshaKubunCode());
        this.setAge(entity.getAge());
        this.setShoKisaiHokenshaNo(entity.getShoKisaiHokenshaNo());
        this.setNinteiShinseiShinseijiKubunCode(entity.getNinteiShinseiShinseijiKubunCode());
        this.setNinteiShinseiHoreiKubunCode(entity.getNinteiShinseiHoreiKubunCode());
        this.setShichosonCode(entity.getShichosonCode());
        this.setShichosonMeisho(entity.getShichosonMeisho());
        this.setHihokenshaNo(entity.getHihokenshaNo());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nijiHanteiYM, nijiHanteiYokaigoJotaiKubunCode, hihokenshaKubunCode, age, shoKisaiHokenshaNo,
                ninteiShinseiShinseijiKubunCode, ninteiShinseiHoreiKubunCode, shichosonCode, shichosonMeisho, hihokenshaNo);
    }
// </editor-fold>
}
