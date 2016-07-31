/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7006RoreiFukushiNenkinJukyushaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.hihokensha.seikatsuhogojukyusha.SeikatsuHogoJukyushaRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 賦課情報の計算登録（6月開始）entity
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
@lombok.Getter
@lombok.Setter
public class FukaJohoLokukatuRelateEntity {

    private Decimal choteigaku;
    private RString hokenryoDankai;
    private FlexibleDate seihoKaishiYMD;
    private FlexibleDate seihoHaishiYMD;
    private FlexibleDate ronenKaishiYMD;
    private FlexibleDate ronenHaishiYMD;
    private RString setaikazeiKubun;
    private RString kazeiKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkinShunyuGaku;
    private DbT1001HihokenshaDaichoEntity 資格の情報;
    private DbT2001ChoshuHohoEntity 徴収方法の情報;
    private List<SeikatsuHogoJukyushaRelateEntity> 生保の情報;
    private List<DbT7006RoreiFukushiNenkinJukyushaEntity> 老齢の情報;

}
