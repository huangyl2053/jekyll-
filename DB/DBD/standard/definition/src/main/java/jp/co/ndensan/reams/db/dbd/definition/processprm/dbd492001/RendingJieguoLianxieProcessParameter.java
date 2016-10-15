/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd492001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd492001.RendingJieguoLianxieMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定結果連携データ取込_process処理のパラメタークラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RendingJieguoLianxieProcessParameter implements IBatchProcessParameter {

    private RString 取込みデータ区分;
    private RString 外部媒体格納パス;
    private List<RString> データリスト;
    private RString 市町村コード;
    private RString 市町村名称;
    private RString 証記載保険者番号;
    private RString 保険者区分;

    /**
     * コンストラクタです。
     *
     * @param 取込みデータ区分 取込みデータ区分
     * @param 外部媒体格納パス 外部媒体格納パス
     * @param データリスト データリスト
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 証記載保険者番号 証記載保険者番号
     * @param 保険者区分 保険者区分
     */
    public RendingJieguoLianxieProcessParameter(RString 取込みデータ区分,
            RString 外部媒体格納パス,
            List<RString> データリスト,
            RString 市町村コード,
            RString 市町村名称,
            RString 証記載保険者番号,
            RString 保険者区分) {
        this.取込みデータ区分 = 取込みデータ区分;
        this.外部媒体格納パス = 外部媒体格納パス;
        this.データリスト = データリスト;
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.証記載保険者番号 = 証記載保険者番号;
        this.保険者区分 = 保険者区分;
    }

    /**
     * ＳＱＬ使用された情報を作成します．
     *
     * @return ＳＱＬ使用された情報を作成します．
     */
    public RendingJieguoLianxieMybatisParameter toRendingJieguoLianxieMybatisParameter() {
        return new RendingJieguoLianxieMybatisParameter(データリスト);
    }

}
