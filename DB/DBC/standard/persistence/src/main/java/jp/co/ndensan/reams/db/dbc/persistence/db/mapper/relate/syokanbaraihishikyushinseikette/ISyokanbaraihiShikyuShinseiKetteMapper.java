/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.syokanbaraihishikyushinseikette;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette.ShafukukeigenServiceResult;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraihishikyushinseikette.ShafukukeigenServiceParameter;

/**
 * 社福軽減額サービス種類のマッパーインタフェースです。
 */
public interface ISyokanbaraihiShikyuShinseiKetteMapper {

    List<ShafukukeigenServiceResult> get社福軽減額サービス種類(ShafukukeigenServiceParameter parameter);

}
