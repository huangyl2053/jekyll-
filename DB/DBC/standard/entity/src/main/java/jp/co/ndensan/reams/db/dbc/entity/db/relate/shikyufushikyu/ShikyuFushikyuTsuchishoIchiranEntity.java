/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shikyufushikyu;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu.DbWT38G1KetteishaIchiranTempEntity;

/**
 * 決定者一覧一時TBL.№　と一致する　帳票関連付け番号をもった<br>
 * 高額合算支給不支給決定者一時データに、決定者一覧一時TBLの口座情報。
 *
 * @reamsid_L DBC-2690-010 zhangrui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShikyuFushikyuTsuchishoIchiranEntity {

    private DbWT38B1KogakuGassanShikyuFushikyuKetteiTempEntity 通知書データ;
    private DbWT38G1KetteishaIchiranTempEntity 一覧データ;

}
