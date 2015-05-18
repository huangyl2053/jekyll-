/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.relate;

import jp.co.ndensan.reams.db.dba.model.relate.shikakuido.JushochiTokureiModel;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住所地特例異動登録時に、1トランザクションで複数のテーブルを更新するためのDacです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiRirekiRelateDac {

    @InjectSession
    private SqlSession session;
    private final DbT1001HihokenshaDaichoDac hihoDaichoDac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
    private final DbT1004ShisetsuNyutaishoDac nyutaishoDac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);

    /**
     * 住所地特例Modelが持つデータを、DBに登録します。
     *
     * @param model 住所地特例Model
     * @return 登録された総件数
     */
    @Transaction
    public int update(JushochiTokureiModel model) {
        int saveNum = 0;

        for (HihokenshaDaichoModel hihoDaicho : model.getHihoDaichoData()) {
            switch (hihoDaicho.getState()) {
//TODO: n8223 朴　DBZのbuildが終わり次第、エラー内容を対応。
                case Added:
                    saveNum += hihoDaichoDac.insert(hihoDaicho.getEntity());
                    break;
                case Modified:
                    saveNum += hihoDaichoDac.update(hihoDaicho.getEntity());
                    break;
                case Deleted:
                    saveNum += hihoDaichoDac.delete(hihoDaicho.getEntity());
                    break;
                case Unchanged:
                default:
                    break;
            }
        }

        for (ShisetsuNyutaishoModel nyutaishoModel : model.getShisetsuNyutaishoData()) {
            switch (nyutaishoModel.getState()) {
//TODO: n8223 朴　DBZのbuildが終わり次第に、コメントアウトする。
                case Added:
                    saveNum += nyutaishoDac.insert(nyutaishoModel.getEntity());
                    break;
                case Modified:
                    saveNum += nyutaishoDac.update(nyutaishoModel.getEntity());
                    break;
                case Deleted:
                    saveNum += nyutaishoDac.delete(nyutaishoModel.getEntity());
                    break;
                default:
                    break;
            }
        }

        return saveNum;
    }
}
