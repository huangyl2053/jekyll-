/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tsuchisho;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * KariSanteiTsuchiShoKyotsuのクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiTsuchiShoKyotsu {

    private FlexibleDate 発行日;
    private RString 帳票分類ID;
    //chohyoBunruiID
    private RString 帳票ID;
    private ShoriKubun 処理区分;
    private Association 地方公共団体;
    private DbT2002FukaEntity 賦課の情報_更正後;
    private DbT2002FukaEntity 賦課の情報_更正前;
    private RString 納組情報;
    //CaFt703FindNokumiEntity
    private List<普徴納期情報Entity> 普徴納期情報リスト;
    private List<特徴納期情報Entity> 特徴納期情報リスト;
    private IAtesaki 宛先情報;
    private DbT2002FukaEntity 前年度賦課情報;
    private IKoza 口座情報;
    private DbT2001ChoshuHohoEntity 徴収方法情報_更正前;
    private DbT2001ChoshuHohoEntity 徴収方法情報_更正後;
    private RString 対象者_追加含む_情報_更正前;
    //UrT0511NenkinTokuchoKaifuJoho
    private RString 対象者_追加含む_情報_更正後;
    //UrT0511NenkinTokuchoKaifuJoho
    private RString 収入情報;
    //ShunyuJoho
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
}
