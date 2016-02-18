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
 *
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KariSanteiTsuchiShoKyotsu {

    FlexibleDate 発行日;
    RString 帳票分類ID;//chohyoBunruiID
    RString 帳票ID;//

    ShoriKubun 処理区分;
    Association 地方公共団体;
    DbT2002FukaEntity 賦課の情報_更正後;
    DbT2002FukaEntity 賦課の情報_更正前;
    RString 納組情報;//CaFt703FindNokumiEntity
    List<普徴納期情報Entity> 普徴納期情報リスト;
    List<特徴納期情報Entity> 特徴納期情報リスト;
    IAtesaki 宛先情報;
    DbT2002FukaEntity 前年度賦課情報;
    IKoza 口座情報;
    DbT2001ChoshuHohoEntity 徴収方法情報_更正前;
    DbT2001ChoshuHohoEntity 徴収方法情報_更正後;
    RString 対象者_追加含む_情報_更正前;//UrT0511NenkinTokuchoKaifuJoho
    RString 対象者_追加含む_情報_更正後;//UrT0511NenkinTokuchoKaifuJoho
    RString 収入情報;//ShunyuJoho
    DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;

}
