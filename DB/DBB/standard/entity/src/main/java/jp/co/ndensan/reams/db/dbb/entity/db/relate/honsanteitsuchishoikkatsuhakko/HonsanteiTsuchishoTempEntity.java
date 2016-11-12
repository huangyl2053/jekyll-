/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.honsanteitsuchishoikkatsuhakko;

import java.io.Serializable;
import jp.co.ndensan.reams.ca.cax.entity.db.psm.CaFt703FindNokumiEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.KozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ue.uex.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 本算定通知書一時テーブルから情報を取得するEntityクラスです。
 *
 * @reamsid_L DBB-0780-060 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HonsanteiTsuchishoTempEntity implements Serializable {

    private DbT2015KeisangoJohoEntity 計算後情報_更正後;
    private DbT2015KeisangoJohoEntity 計算後情報_更正前;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む_情報_更正後;
    private UeT0511NenkinTokuchoKaifuJohoEntity 対象者_追加含む_情報_更正前;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private UaFt250FindAtesakiEntity 宛先;
    private CaFt703FindNokumiEntity 納組;
    private TokuteiKozaRelateEntity 特定口座;
    private KozaRelateEntity 口座;
    private UaFt250FindAtesakiEntity 宛先代納;
    private RString 更正前情報有無区分;
    private RString 生活保護区分;
    private RString 決定変更区分;
    private RString 出力順グループ指定;
    private RString 特徴8月開始者区分;
    private RString 特徴10月開始者区分;
}
