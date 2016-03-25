/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.ninteishinsakaiiinguide;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 審査会委員一覧情報のMyBatis用パラメータクラスです。
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiShinsakaiIinGuideMapperParameter {

    private final RString shinsakaiIinCodeFrom;
    private final RString shinsakaiIinCodeTo;
    private final AtenaMeisho shinsakaiIinShimei;
    private final RString seibetsu;
    private final Code shinsakaiIinShikakuCode;
    private final RString shujiiIryokikanCode;
    private final RString ninteiChosainNo;
    private final RString sonotaKikanCode;
    private final RString kikenFlag;
    private final RString haishiFlag;
    private final Decimal maxKensu;
    private final FlexibleDate systemDate;
    private final ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private final boolean isShinsakaiIinKaishiYMDFlag;
    private final boolean isShinsakaiIinShuryoYMDFlag;
    private final boolean isShinsakaiIinShimeiFlag;
    private final boolean isSeibetsuFlag;
    private final boolean isShinsakaiIinShikakuCodeFlag;
    private final boolean isShujiiIryokikanCodeFlag;
    private final boolean isNinteiChosainNoFlag;
    private final boolean isSonotaKikanCodeFlag;
    private final boolean isShoKisaiHokenshaNoFlag;

    /**
     * コンストラクタです。
     *
     * @param shinsakaiIinCodeFrom 審査会委員コードFrom
     * @param shinsakaiIinCodeTo 審査会委員コードTo
     * @param shinsakaiIinShimei 介護認定審査会委員氏名
     * @param seibetsu 性別
     * @param shinsakaiIinShikakuCode 介護認定審査会委員コード
     * @param shujiiIryokikanCode 主治医医療機関コード
     * @param ninteiChosainNo 認定調査委託先コード
     * @param sonotaKikanCode その他機関コード
     * @param kikenFlag 期限
     * @param haishiFlag 廃止
     * @param maxKensu 最大取得件数上限
     * @param systemDate SYSTEMDATE
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @return 審査会委員一覧情報の検索パラメータ
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private NinteiShinsakaiIinGuideMapperParameter(
            RString shinsakaiIinCodeFrom,
            RString shinsakaiIinCodeTo,
            AtenaMeisho shinsakaiIinShimei,
            RString seibetsu,
            Code shinsakaiIinShikakuCode,
            RString shujiiIryokikanCode,
            RString ninteiChosainNo,
            RString sonotaKikanCode,
            RString kikenFlag,
            RString haishiFlag,
            Decimal maxKensu,
            FlexibleDate systemDate,
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            boolean isShinsakaiIinKaishiYMDFlag,
            boolean isShinsakaiIinShuryoYMDFlag,
            boolean isShinsakaiIinShimeiFlag,
            boolean isSeibetsuFlag,
            boolean isShinsakaiIinShikakuCodeFlag,
            boolean isShujiiIryokikanCodeFlag,
            boolean isNinteiChosainNoFlag,
            boolean isSonotaKikanCodeFlag,
            boolean isShoKisaiHokenshaNoFlag) {
        this.shinsakaiIinCodeFrom = shinsakaiIinCodeFrom;
        this.shinsakaiIinCodeTo = shinsakaiIinCodeTo;
        this.shinsakaiIinShimei = shinsakaiIinShimei;
        this.seibetsu = seibetsu;
        this.shinsakaiIinShikakuCode = shinsakaiIinShikakuCode;
        this.shujiiIryokikanCode = shujiiIryokikanCode;
        this.ninteiChosainNo = ninteiChosainNo;
        this.sonotaKikanCode = sonotaKikanCode;
        this.kikenFlag = kikenFlag;
        this.haishiFlag = haishiFlag;
        this.maxKensu = maxKensu;
        this.systemDate = systemDate;
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
        this.isShinsakaiIinKaishiYMDFlag = isShinsakaiIinKaishiYMDFlag;
        this.isShinsakaiIinShuryoYMDFlag = isShinsakaiIinShuryoYMDFlag;
        this.isShinsakaiIinShimeiFlag = isShinsakaiIinShimeiFlag;
        this.isSeibetsuFlag = isSeibetsuFlag;
        this.isShinsakaiIinShikakuCodeFlag = isShinsakaiIinShikakuCodeFlag;
        this.isShujiiIryokikanCodeFlag = isShujiiIryokikanCodeFlag;
        this.isNinteiChosainNoFlag = isNinteiChosainNoFlag;
        this.isSonotaKikanCodeFlag = isSonotaKikanCodeFlag;
        this.isShoKisaiHokenshaNoFlag = isShoKisaiHokenshaNoFlag;

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinsakaiIinKaishiYMD 審査会委員コードFrom
     * @param shinsakaiIinShuryoYMD 審査会委員コードTo
     * @param shinsakaiIinShimei 介護認定審査会委員氏名
     * @param seibetsu 性別
     * @param shinsakaiIinShikakuCode 介護認定審査会委員コード
     * @param shujiiIryokikanCode 主治医医療機関コード
     * @param ninteiChosainNo 認定調査委託先コード
     * @param sonotaKikanCode その他機関コード
     * @param kikenFlag 期限
     * @param haishiFlag 廃止
     * @param maxKensu 最大取得件数上限
     * @param systemDate SYSTEMDATE
     * @param shoKisaiHokenshaNo 証記載保険者番号
     * @return 審査会委員一覧情報の検索パラメータ
     */
    public static NinteiShinsakaiIinGuideMapperParameter createSelectByKeyParam(
            RString shinsakaiIinKaishiYMD,
            RString shinsakaiIinShuryoYMD,
            AtenaMeisho shinsakaiIinShimei,
            RString seibetsu,
            Code shinsakaiIinShikakuCode,
            RString shujiiIryokikanCode,
            RString ninteiChosainNo,
            RString sonotaKikanCode,
            RString kikenFlag,
            RString haishiFlag,
            Decimal maxKensu,
            ShoKisaiHokenshaNo shoKisaiHokenshaNo,
            FlexibleDate systemDate) {
        boolean isShinsakaiIinKaishiYMDFlag = false;
        boolean isShinsakaiIinShuryoYMDFlag = false;
        boolean isShinsakaiIinShimeiFlag = false;
        boolean isSeibetsuFlag = false;
        boolean isShinsakaiIinShikakuCodeFlag = false;
        boolean isShujiiIryokikanCodeFlag = false;
        boolean isNinteiChosainNoFlag = false;
        boolean isSonotaKikanCodeFlag = false;
        boolean isShoKisaiHokenshaNoFlag = false;

        if (shinsakaiIinKaishiYMD != null && !shinsakaiIinKaishiYMD.isEmpty()) {
            isShinsakaiIinKaishiYMDFlag = true;
        }
        if (shinsakaiIinShuryoYMD != null && !shinsakaiIinShuryoYMD.isEmpty()) {
            isShinsakaiIinShuryoYMDFlag = true;
        }
        if (shinsakaiIinShimei != null && !shinsakaiIinShimei.isEmpty()) {
            isShinsakaiIinShimeiFlag = true;
        }
        if (seibetsu != null && !seibetsu.isEmpty()) {
            isSeibetsuFlag = true;
        }
        if (shinsakaiIinShikakuCode != null && !shinsakaiIinShikakuCode.isEmpty()) {
            isShinsakaiIinShikakuCodeFlag = true;
        }
        if (shujiiIryokikanCode != null && !shujiiIryokikanCode.isEmpty()) {
            isShujiiIryokikanCodeFlag = true;
        }
        if (ninteiChosainNo != null && !ninteiChosainNo.isEmpty()) {
            isNinteiChosainNoFlag = true;
        }
        if (sonotaKikanCode != null && !sonotaKikanCode.isEmpty()) {
            isSonotaKikanCodeFlag = true;
        }
        if (shoKisaiHokenshaNo != null && !shoKisaiHokenshaNo.isEmpty()) {
            isShoKisaiHokenshaNoFlag = true;
        }
        return new NinteiShinsakaiIinGuideMapperParameter(
                shinsakaiIinKaishiYMD,
                shinsakaiIinShuryoYMD,
                shinsakaiIinShimei,
                seibetsu,
                shinsakaiIinShikakuCode,
                shujiiIryokikanCode,
                ninteiChosainNo,
                sonotaKikanCode,
                kikenFlag,
                haishiFlag,
                maxKensu,
                systemDate,
                shoKisaiHokenshaNo,
                isShinsakaiIinKaishiYMDFlag,
                isShinsakaiIinShuryoYMDFlag,
                isShinsakaiIinShimeiFlag,
                isSeibetsuFlag,
                isShinsakaiIinShikakuCodeFlag,
                isShujiiIryokikanCodeFlag,
                isNinteiChosainNoFlag,
                isSonotaKikanCodeFlag,
                isShoKisaiHokenshaNoFlag);
    }

}
