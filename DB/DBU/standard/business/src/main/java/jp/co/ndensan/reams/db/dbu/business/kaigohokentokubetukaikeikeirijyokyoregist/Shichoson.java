/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.kaigohokentokubetukaikeikeirijyokyoregist;

import jp.co.ndensan.reams.db.dbu.entity.kaigohokentokubetukaikeikeirijyokyoregist.ShichosonEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 市町村を管理するビジネスです。
 */
public class Shichoson {

    private final ShichosonEntity 市町村;

    /**
     * コンストラクタです。<br/>
     *
     */
    public Shichoson() {
        this.市町村 = new ShichosonEntity(LasdecCode.EMPTY, RString.EMPTY, ShoKisaiHokenshaNo.EMPTY, TokeiTaishoKubun.空);
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 市町村 市町村
     * @link ShichosonEntity}より{@link Shichoson}を生成します。
     *
     * @param 市町村 @link ShichosonEntity}
     */
    public Shichoson(ShichosonEntity 市町村) {
        this.市町村 = 市町村;
    }

    /**
     * コンストラクタです。<br/>
     *
     * @param 市町村コード
     * @param 市町村名称
     * @param 保険者コード
     * @param 保険者区分
     */
    public Shichoson(LasdecCode 市町村コード, RString 市町村名称, ShoKisaiHokenshaNo 保険者コード, TokeiTaishoKubun 保険者区分) {
        this.市町村 = new ShichosonEntity(市町村コード, 市町村名称, 保険者コード, 保険者区分);
    }

    /**
     * 市町村を返します。
     *
     * @return 市町村
     */
    public ShichosonEntity get市町村() {
        return 市町村;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村.get市町村コード();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return 市町村.get市町村名称();
    }

    /**
     * 保険者コードを返します。
     *
     * @return 保険者コード
     */
    public ShoKisaiHokenshaNo get保険者コード() {
        return 市町村.get保険者コード();
    }

    /**
     * 保険者区分を返します。
     *
     * @return 保険者区分
     */
    public TokeiTaishoKubun get保険者区分() {
        return 市町村.get保険者区分();
    }
}
