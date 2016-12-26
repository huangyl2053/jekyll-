/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601005;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査報酬照会のProcessParameterです。
 *
 * @reamsid_L DBE-1940-020 jinjue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiChosaHoshuShokaiProcessParameter implements IBatchProcessParameter {

    private final RString 帳票出力区分;
    private final RString 調査依頼日開始;
    private final RString 調査依頼日終了;
    private final List<NinteiChosaHoshuShokaiFlowBusiness> キー情報Entityリスト;
    private final RString 保険者;
    private final boolean is広域;
    private final RString 広域_市町村名;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param 調査依頼日開始 調査依頼日開始
     * @param 調査依頼日終了 調査依頼日終了
     * @param キー情報Entityリスト キー情報Entityリスト
     * @param 保険者 保険者
     * @param is広域 広域フラグ
     * @param 広域_市町村名 広域_市町村名
     *
     */
    public NinteiChosaHoshuShokaiProcessParameter(RString 帳票出力区分, RString 調査依頼日開始, RString 調査依頼日終了,
            List<NinteiChosaHoshuShokaiFlowBusiness> キー情報Entityリスト, RString 保険者, boolean is広域, RString 広域_市町村名) {
        this.帳票出力区分 = 帳票出力区分;
        this.キー情報Entityリスト = キー情報Entityリスト;
        this.調査依頼日開始 = 調査依頼日開始;
        this.調査依頼日終了 = 調査依頼日終了;
        this.保険者 = 保険者;
        this.is広域 = is広域;
        this.広域_市町村名 = 広域_市町村名;

    }

    /**
     * 認定調査報酬照会のmapperのparameterを作成します。
     *
     * @return 認定調査報酬照会のmapperのparameter
     */
    public NinteiChosaHoshuShokaiMapperParameter toMybitisParamter() {
        return NinteiChosaHoshuShokaiMapperParameter.createParamter(DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分,
                RDate.getNowDate(), SubGyomuCode.DBE認定支援), 調査依頼日開始, 調査依頼日終了, true, キー情報Entityリスト, 保険者, is広域, 広域_市町村名);
    }
}
