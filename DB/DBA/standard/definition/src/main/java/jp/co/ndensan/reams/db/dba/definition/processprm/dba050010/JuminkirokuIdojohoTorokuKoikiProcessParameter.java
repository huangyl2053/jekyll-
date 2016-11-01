/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.dba050010;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.juminkirokuidojohotorokukoiki.JuminkirokuIdojohoTorokuKoikiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住民異動連携情報登録【広域保険者用】のProcessParameterのパラメータ。
 *
 * @reamsid_L DBA-1390-010 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JuminkirokuIdojohoTorokuKoikiProcessParameter implements IBatchProcessParameter {

    private YMDHMS syorinichiji;
    private RString shichosonCode;

    /**
     * コンストラクタ。
     *
     * @param syorinichiji 処理日時
     * @param shichosonCode 市町村コード
     */
    public JuminkirokuIdojohoTorokuKoikiProcessParameter(
            YMDHMS syorinichiji,
            RString shichosonCode) {
        this.syorinichiji = syorinichiji;
        this.shichosonCode = shichosonCode;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @return JuminkirokuIdojohoTorokuKoikiMybatisParameter
     */
    public JuminkirokuIdojohoTorokuKoikiMybatisParameter toJuminkirokuIdojohoTorokuKoikiMybatisParameter() {
        return JuminkirokuIdojohoTorokuKoikiMybatisParameter.createMybatisParameter(syorinichiji, shichosonCode);
    }

}
