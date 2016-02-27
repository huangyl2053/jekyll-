/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.jigyohokokunenpo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 市町村EntiyのBusinessクラスです。
 *
 */
public class ShichosonCodeNameResult {

    private final LasdecCode 市町村コード;
    private final RString 市町村名称;
    private final ShoKisaiHokenshaNo 保険者コード;
    private final RString 保険者区分;

    /**
     * 市町村EntiyのBusinessクラス作成処理
     *
     * @param 市町村コード 市町村コード
     * @param 市町村名称 市町村名称
     * @param 保険者コード 保険者コード
     * @param 保険者区分 保険者区分
     */
    public ShichosonCodeNameResult(LasdecCode 市町村コード, RString 市町村名称, ShoKisaiHokenshaNo 保険者コード, RString 保険者区分) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.保険者コード = 保険者コード;
        this.保険者区分 = 保険者区分;
    }

    /**
     * 市町村コードを取得する。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return 市町村コード;
    }

    /**
     * 市町村名称を取得する。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return 市町村名称;
    }

    /**
     * 保険者コードを取得する。
     *
     * @return 保険者コード
     */
    public ShoKisaiHokenshaNo get保険者コード() {
        return 保険者コード;
    }

    /**
     * 保険者区分を取得する。
     *
     * @return 保険者区分
     */
    public RString get保険者区分() {
        return 保険者区分;
    }
}
