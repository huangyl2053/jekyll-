/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.business.JukyushaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;

/**
 * ビルドエラー回避のための暫定クラス
 *
 * @author n8187
 */
public class JukyushaDaichoManager {

    public Optional<JukyushaDaicho> get直近受給者台帳(HihokenshaNo hihokenshaNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Optional<JukyushaDaicho> get受給者台帳By申請書管理番号(ShinseishoKanriNo shinseishoKanriNo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
