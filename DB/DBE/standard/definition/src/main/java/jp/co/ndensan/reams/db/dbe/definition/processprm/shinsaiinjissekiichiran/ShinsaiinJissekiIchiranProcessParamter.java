/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.shinsaiinjissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員報酬集計表のプロセスパラメータです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsaiinJissekiIchiranProcessParamter implements IBatchProcessParameter {

    private final RString 帳票出力区分;
    private final RString 審査会開催日FROM;
    private final RString 審査会開催日TO;
    private final List<ShinsaiinJissekiIchiranKey> keyJoho;

    /**
     * コンストラクタです。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param 審査会開催日FROM 審査会開催日FROM
     * @param 審査会開催日TO 審査会開催日TO
     * @param keyJoho キー情報Entityリスト
     */
    public ShinsaiinJissekiIchiranProcessParamter(RString 帳票出力区分,
            RString 審査会開催日FROM,
            RString 審査会開催日TO,
            List<ShinsaiinJissekiIchiranKey> keyJoho) {
        this.帳票出力区分 = 帳票出力区分;
        this.審査会開催日FROM = 審査会開催日FROM;
        this.審査会開催日TO = 審査会開催日TO;
        this.keyJoho = keyJoho;
    }

    /**
     * 介護認定審査会委員報酬集計表のデータ取得パラメータを作成します
     *
     * @return 介護認定審査会委員報酬集計表のデータ取得パラメータ
     */
    public ShinsaiinJissekiIchiranMybitisParamter toMybitisParameter() {
        return ShinsaiinJissekiIchiranMybitisParamter.createParamter(true,
                審査会開催日FROM,
                審査会開催日TO,
                keyJoho);
    }
}
