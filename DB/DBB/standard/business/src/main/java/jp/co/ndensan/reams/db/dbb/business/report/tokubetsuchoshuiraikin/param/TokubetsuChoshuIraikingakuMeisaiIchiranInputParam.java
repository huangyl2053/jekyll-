/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraikin.param;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.kanri.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.business.core.choshuhoho.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ue.uex.business.core.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBRP44002_特別徴収依頼金額明細一覧表の入力パラメータ
 *
 * @reamsid_L DBB-0880-080 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokubetsuChoshuIraikingakuMeisaiIchiranInputParam {

    private final DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity;
    private final IKojin 宛名;
    private final NenkinTokuchoKaifuJoho 年金特徴回付情報;
    private final ChoshuHoho 徴収方法;
    private final List<RString> 出力項目リスト;
    private final List<RString> 改頁項目リスト;
    private final FlexibleYear 賦課年度;
    private final RDateTime 調定日時;
    private final Association 地方公共団体;
    private final HokenryoDankai 保険料段階;
    private final ChohyoSeigyoKyotsu 帳票制御共通;
    private final boolean 本算定Flag;

    /**
     * コンストラクタです。
     *
     * @param 賦課の情報一時Entity DbT2002FukaJohoTempTableEntity
     * @param 宛名 IKojin
     * @param 年金特徴回付情報 NenkinTokuchoKaifuJoho
     * @param 徴収方法 ChoshuHoho
     * @param 出力項目リスト List<RString>
     * @param 改頁項目リスト List<RString>
     * @param 賦課年度 FlexibleYear
     * @param 調定日時 RDateTime
     * @param 地方公共団体 Association
     * @param 保険料段階 HokenryoDankai
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     * @param 本算定Flag boolean
     */
    public TokubetsuChoshuIraikingakuMeisaiIchiranInputParam(DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity,
            IKojin 宛名, NenkinTokuchoKaifuJoho 年金特徴回付情報, ChoshuHoho 徴収方法, List<RString> 出力項目リスト,
            List<RString> 改頁項目リスト, FlexibleYear 賦課年度, RDateTime 調定日時, Association 地方公共団体,
            HokenryoDankai 保険料段階, ChohyoSeigyoKyotsu 帳票制御共通, boolean 本算定Flag) {
        this.賦課の情報一時Entity = 賦課の情報一時Entity;
        this.宛名 = 宛名;
        this.年金特徴回付情報 = 年金特徴回付情報;
        this.徴収方法 = 徴収方法;
        this.出力項目リスト = 出力項目リスト;
        this.改頁項目リスト = 改頁項目リスト;
        this.賦課年度 = 賦課年度;
        this.調定日時 = 調定日時;
        this.地方公共団体 = 地方公共団体;
        this.保険料段階 = 保険料段階;
        this.帳票制御共通 = 帳票制御共通;
        this.本算定Flag = 本算定Flag;
    }

}
