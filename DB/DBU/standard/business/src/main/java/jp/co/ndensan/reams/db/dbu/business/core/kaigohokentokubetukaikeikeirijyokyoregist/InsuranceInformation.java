/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.kaigohokentokubetukaikeikeirijyokyoregist;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kaigohokentokubetukaikeikeirijyokyoregist.InsuranceInformationEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護保険特別会計経理状況登録遷移先渡す項目を管理するビジネスです。
 *
 * @reamsid_L DBU-1130-010 wangjie2
 */
public class InsuranceInformation implements Serializable {

    private final InsuranceInformationEntity insuranceInformationEntity;
    private static final long serialVersionUID = 1;

    /**
     * コンストラクタです。<br/>
     *
     * @param insuranceInformationEntity 遷移先渡す項目
     * @link InsuranceInformationEntity}より{@link InsuranceInformation}を生成します。
     */
    public InsuranceInformation(InsuranceInformationEntity insuranceInformationEntity) {
        this.insuranceInformationEntity = requireNonNull(insuranceInformationEntity,
                UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険特別会計経理状況登録遷移先渡す項目のエンティティ"));
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 処理フラグ 処理フラグ
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     */
    public InsuranceInformation(RString 処理フラグ, LasdecCode 市町村コード, RString 市町村名称) {
        this.insuranceInformationEntity = new InsuranceInformationEntity(FlexibleYear.EMPTY, FlexibleYear.EMPTY, RString.EMPTY, 市町村コード,
                Code.EMPTY, 処理フラグ, ShoKisaiHokenshaNo.EMPTY, 市町村名称, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     */
    public InsuranceInformation() {
        this.insuranceInformationEntity = new InsuranceInformationEntity(FlexibleYear.EMPTY, FlexibleYear.EMPTY, RString.EMPTY, LasdecCode.EMPTY,
                Code.EMPTY, RString.EMPTY, ShoKisaiHokenshaNo.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 報告年 報告年
     * @param 集計対象年 集計対象年
     * @param 統計対象区分 統計対象区分
     * @param 市町村コード 市町村コード
     * @param 表番号 表番号
     * @param 処理フラグ 処理フラグ
     * @param 保険者コード 保険者コード
     * @param 市町村名称 市町村名称
     * @param 様式４入力状況 様式４入力状況
     * @param 様式４の２入力状況 様式４の２入力状況
     * @param 様式４の３入力状況 様式４の３入力状況
     */
    public InsuranceInformation(FlexibleYear 報告年,
            FlexibleYear 集計対象年,
            RString 統計対象区分,
            LasdecCode 市町村コード,
            Code 表番号,
            RString 処理フラグ,
            ShoKisaiHokenshaNo 保険者コード,
            RString 市町村名称,
            RString 様式４入力状況,
            RString 様式４の２入力状況,
            RString 様式４の３入力状況
    ) {
        this.insuranceInformationEntity = new InsuranceInformationEntity(報告年, 集計対象年, 統計対象区分,
                市町村コード, 表番号, 処理フラグ, 保険者コード, 市町村名称, 様式４入力状況, 様式４の２入力状況, 様式４の３入力状況);
    }

    /**
     * 介護保険特別会計経理状況登録遷移先渡す項目のエンティティ返します。
     *
     * @return 介護保険特別会計経理状況登録遷移先渡す項目のエンティティ
     */
    public InsuranceInformationEntity getInsuranceInformationEntity() {
        return insuranceInformationEntity;
    }

    /**
     * 報告年を返します。
     *
     * @return 報告年
     */
    public FlexibleYear get報告年() {
        return insuranceInformationEntity.get報告年();
    }

    /**
     * 集計対象年を返します。
     *
     * @return 集計対象年
     */
    public FlexibleYear get集計対象年() {
        return insuranceInformationEntity.get集計対象年();
    }

    /**
     * 保険者コードを返します。
     *
     * @return 保険者コード
     */
    public ShoKisaiHokenshaNo get保険者コード() {
        return insuranceInformationEntity.get保険者コード();
    }

    /**
     * 処理フラグを返します。
     *
     * @return 処理フラグ
     */
    public RString get処理フラグ() {
        return insuranceInformationEntity.get処理フラグ();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return insuranceInformationEntity.get市町村名称();
    }

    /**
     * 統計対象区分を返します。
     *
     * @return 統計対象区分
     */
    public RString get統計対象区分() {
        return insuranceInformationEntity.get統計対象区分();
    }

    /**
     * 様式４入力状況を返します。
     *
     * @return 様式４入力状況
     */
    public RString get様式４入力状況() {
        return insuranceInformationEntity.get様式４入力状況();
    }

    /**
     * 様式４の２入力状況を返します。
     *
     * @return 様式４の２入力状況
     */
    public RString get様式４の２入力状況() {
        return insuranceInformationEntity.get様式４の２入力状況();
    }

    /**
     * 様式４の３入力状況を返します。
     *
     * @return 様式４の３入力状況
     */
    public RString get様式４の３入力状況() {
        return insuranceInformationEntity.get様式４の３入力状況();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return insuranceInformationEntity.get市町村コード();
    }

    /**
     * 表番号を返します。
     *
     * @return 表番号
     */
    public Code get表番号() {
        return insuranceInformationEntity.get表番号();
    }

}
