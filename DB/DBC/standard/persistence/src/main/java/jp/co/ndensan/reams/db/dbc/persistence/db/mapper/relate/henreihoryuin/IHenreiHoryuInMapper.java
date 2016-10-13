/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.henreihoryuin;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyumeisai.SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity;

/**
 * 請求明細・給付管理票返戻（保留）一覧表取込のマッパーインタフェースです。
 *
 * @reamsid_L DBC-2830-010 yaodongsheng
 */
public interface IHenreiHoryuInMapper {

    /**
     * データの取得
     *
     * @return SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntityList
     */
    List<SeikyumeisaiKyufukanrihyoHenreiHoryuIchiranEntity> get帳票出力対象データ();
}
