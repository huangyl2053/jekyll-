/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬照会のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1940-010 jinjue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteiChosaHoshuShokaiMapperParameter implements IMyBatisParameter {

    private final RString テキストイメージ区分;
    private final RString 調査依頼日終了;
    private final RString 調査依頼日開始;
    private final int 最大表示件数;
    private final RString 通常区分;
    private final RString 延期区分;
    private final boolean batchFlag;
    private final boolean 件数Flag;
    private final List<NinteiChosaHoshuShokaiFlowBusiness> ninteiChosa;
    private final boolean isFrom;
    private final boolean isTo;
    private final boolean isHokensha;
    private final RString 保険者;
    private final RString 保険者名;
    private final boolean isKoiki;
    private final RString 広域_市町村名;

    private NinteiChosaHoshuShokaiMapperParameter(RString テキストイメージ区分, RString 調査依頼日開始,
            RString 調査依頼日終了, boolean 件数Flag, int 最大表示件数, RString 通常区分, RString 延期区分, boolean batchFlag,
            List<NinteiChosaHoshuShokaiFlowBusiness> ninteiChosa, boolean isFrom, boolean isTo, boolean isHokensha, RString 保険者,
            RString 保険者名, boolean isKoiki, RString 広域_市町村名) {
        this.テキストイメージ区分 = テキストイメージ区分;
        this.調査依頼日開始 = 調査依頼日開始;
        this.調査依頼日終了 = 調査依頼日終了;
        this.件数Flag = 件数Flag;
        this.最大表示件数 = 最大表示件数;
        this.通常区分 = 通常区分;
        this.延期区分 = 延期区分;
        this.batchFlag = batchFlag;
        this.ninteiChosa = ninteiChosa;
        this.isFrom = isFrom;
        this.isTo = isTo;
        this.isHokensha = isHokensha;
        this.保険者 = 保険者;
        this.保険者名 = 保険者名;
        this.isKoiki = isKoiki;
        this.広域_市町村名 = 広域_市町村名;
    }

    /**
     * 報酬実績データ情報のパラメータを生成します。
     *
     * @param テキストイメージ区分 テキストイメージ区分
     * @param 調査依頼日開始 調査依頼日開始
     * @param 調査依頼日終了 調査依頼日終了
     * @param 最大表示件数 最大表示件数
     * @param batchFlag batchの判断マーク
     * @param ninteiChosa キーの情報
     * @param 保険者 保険者
     * @param 保険者名 保険者名
     * @param is広域 広域フラグ
     * @param 広域_市町村名称 広域_市町村名称
     * @return 報酬実績データ情報のパラメータ
     */
    public static NinteiChosaHoshuShokaiMapperParameter createSelectBy情報(RString テキストイメージ区分, RString 調査依頼日開始,
            RString 調査依頼日終了, int 最大表示件数, boolean batchFlag, List<NinteiChosaHoshuShokaiFlowBusiness> ninteiChosa, RString 保険者,
            RString 保険者名, boolean is広域, RString 広域_市町村名称) {
        return new NinteiChosaHoshuShokaiMapperParameter(テキストイメージ区分, 調査依頼日開始, 調査依頼日終了, true, 最大表示件数,
                ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), batchFlag, ninteiChosa,
                !RString.isNullOrEmpty(調査依頼日開始), !RString.isNullOrEmpty(調査依頼日終了), !RString.isNullOrEmpty(保険者), 保険者,
                保険者名, is広域, 広域_市町村名称);
    }

    /**
     * 報酬実績データ情報のbatchのＳＱＬパラメータを生成します。
     *
     * @param テキストイメージ区分 テキストイメージ区分
     * @param 調査依頼日開始 調査依頼日開始
     * @param 調査依頼日終了 調査依頼日終了
     * @param batchFlag batchの判断マーク
     * @param ninteiChosa キーの情報
     * @param 保険者 保険者
     * @param 保険者名 保険者名
     * @param is広域 広域フラグ
     * @param 広域_市町村名 広域_市町村名
     * @return 報酬実績データ情報のパラメータ
     */
    public static NinteiChosaHoshuShokaiMapperParameter createParamter(RString テキストイメージ区分, RString 調査依頼日開始,
            RString 調査依頼日終了, boolean batchFlag, List<NinteiChosaHoshuShokaiFlowBusiness> ninteiChosa, RString 保険者,
            RString 保険者名, boolean is広域, RString 広域_市町村名) {
        return new NinteiChosaHoshuShokaiMapperParameter(DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援), 調査依頼日開始, 調査依頼日終了, false, 0,
                ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード(), batchFlag, ninteiChosa,
                !RString.isNullOrEmpty(調査依頼日開始), !RString.isNullOrEmpty(調査依頼日終了), !RString.isNullOrEmpty(保険者), 保険者,
                保険者名, is広域, 広域_市町村名);
    }
}
