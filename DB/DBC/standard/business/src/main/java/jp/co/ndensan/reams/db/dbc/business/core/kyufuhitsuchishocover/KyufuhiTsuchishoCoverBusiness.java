/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyufuhitsuchishocover;

import jp.co.ndensan.reams.db.dbc.entity.db.kyufuhitsuchishocover.KyufuhiTsuchishoCoverEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC100041_介護保険給付費通知書の情報インターフェースです。
 *
 * @reamsid_L DBC-2280-040 lizhuoxuan
 */
public class KyufuhiTsuchishoCoverBusiness {

    private final KyufuhiTsuchishoCoverEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 帳票設計_DBC100041_介護保険給付費通知書情報Entityクラス
     */
    public KyufuhiTsuchishoCoverBusiness(KyufuhiTsuchishoCoverEntity entity) {
        this.entity = entity;
    }

    /**
     * 文書番号を取得します。
     *
     * @return 文書番号
     */
    public RString get文書番号() {
        return entity.getBunshoNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * サービス集計開始年月を取得します。
     *
     * @return サービス集計開始年月
     */
    public RString getサービス集計開始年月() {
        return entity.getShukeiserviceSTYM();
    }

    /**
     * サービス集計終了年月を取得します。
     *
     * @return サービス集計終了年月
     */
    public RString getサービス集計終了年月() {
        return entity.getShukeiserviceEDYM();
    }

    /**
     * 問い合わせ先を取得します。
     *
     * @return 問い合わせ先
     */
    public RString get問い合わせ先() {
        return entity.getToiawasesakiTitle();
    }

    /**
     * サービス提供年月を取得します。
     *
     * @return サービス提供年月
     */
    public RString getサービス提供年月() {
        return entity.getListServiceIchiranUpper_1();
    }

    /**
     * サービス事業者を取得します。
     *
     * @return サービス事業者
     */
    public RString getサービス事業者() {
        return entity.getListServiceIchiranUpper_2();
    }

    /**
     * サービス種類_サービス略称を取得します。
     *
     * @return サービス種類_サービス略称
     */
    public RString getサービス種類_サービス略称() {
        return entity.getListServiceIchiranUpper_3();
    }

    /**
     * サービス日数_回数を取得します。
     *
     * @return サービス日数_回数
     */
    public RString getサービス日数_回数() {
        return entity.getListServiceIchiranUpper_4();
    }

    /**
     * 利用者負担額合計額_円を取得します。
     *
     * @return 利用者負担額合計額_円
     */
    public RString get利用者負担額合計額_円() {
        return entity.getListServiceIchiranUpper_5();
    }

    /**
     * サービス費用合計額_円を取得します。
     *
     * @return サービス費用合計額_円
     */
    public RString getサービス費用合計額_円() {
        return entity.getListServiceIchiranUpper_6();
    }

    /**
     * サービス事業者_1を取得します。
     *
     * @return サービス事業者_1
     */
    public RString getサービス事業者_1() {
        return entity.getListServiceIchiranLower_1();
    }

    /**
     * サービス種類_サービス略称_1を取得します。
     *
     * @return サービス種類_サービス略称_1
     */
    public RString getサービス種類_サービス略称_1() {
        return entity.getListServiceIchiranLower_2();
    }

    /**
     * 通知文1を取得します。
     *
     * @return 通知文1
     */
    public RString get通知文1() {
        return entity.getTsuchibun1();
    }

    /**
     * 通知文2を取得します。
     *
     * @return 通知文2
     */
    public RString get通知文2() {
        return entity.getTsuchibun2();
    }

    /**
     * ページ分子を取得します。
     *
     * @return ページ分子
     */
    public int getページ分子() {
        return entity.getPageBunshi();
    }

    /**
     * ページ分母を取得します。
     *
     * @return ページ分母
     */
    public int getページ分母() {
        return entity.getPageBunbo();
    }

    /**
     * 電子公印を取得します。
     *
     * @return 電子公印
     */
    public RString get電子公印() {
        return entity.getDenshiKoin();
    }

    /**
     * 発行日を取得します。
     *
     * @return 発行日
     */
    public RString get発行日() {
        return entity.getHakkoYMD();
    }

    /**
     * 認証者役職名を取得します。
     *
     * @return 認証者役職名
     */
    public RString get都認証者役職名() {
        return entity.getNinshoshaYakushokuMei();
    }

    /**
     * 認証者役職名1を取得します。
     *
     * @return 認証者役職名1
     */
    public RString get認証者役職名1() {
        return entity.getNinshoshaYakushokuMei1();
    }

    /**
     * 認証者役職名2 を取得します。
     *
     * @return 認証者役職名2
     */
    public RString get認証者役職名2() {
        return entity.getNinshoshaYakushokuMei2();
    }

    /**
     * 認証者氏名_公印に掛けないを取得します。
     *
     * @return 認証者氏名_公印に掛けない
     */
    public RString get認証者氏名_公印に掛けない() {
        return entity.getNinshoshaShimeiKakenai();
    }

    /**
     * 認証者氏名_公印に掛けるを取得します。
     *
     * @return 認証者氏名_公印に掛ける
     */
    public RString get認証者氏名_公印に掛ける() {
        return entity.getNinshoshaShimeiKakeru();
    }

    /**
     * 公印省略を取得します。
     *
     * @return 公印省略
     */
    public RString get公印省略() {
        return entity.getKoinShoryaku();
    }

    /**
     * 公印文字列を取得します。
     *
     * @return 公印文字列
     */
    public RString get公印文字列() {
        return entity.getKoinMojiretsu();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 行政区を取得します。
     *
     * @return 行政区
     */
    public RString get行政区() {
        return entity.getGyoseiku();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJushoText();
    }

    /**
     * 住所1を取得します。
     *
     * @return 住所1
     */
    public RString get住所1() {
        return entity.getJusho4();
    }

    /**
     * 住所2を取得します。
     *
     * @return 住所2
     */
    public RString get住所2() {
        return entity.getJusho5();
    }

    /**
     * 住所3を取得します。
     *
     * @return 住所3
     */
    public RString get住所3() {
        return entity.getJusho6();
    }

    /**
     * 方書1を取得します。
     *
     * @return 方書1
     */
    public RString get方書1() {
        return entity.getKatagakiText();
    }

    /**
     * 方書2を取得します。
     *
     * @return 方書2
     */
    public RString get方書2() {
        return entity.getKatagaki3();
    }

    /**
     * 方書3を取得します。
     *
     * @return 方書3
     */
    public RString get方書3() {
        return entity.getKatagaki4();
    }

    /**
     * 方書4を取得します。
     *
     * @return 方書4
     */
    public RString get方書4() {
        return entity.getKatagakiSmall1();
    }

    /**
     * 方書5を取得します。
     *
     * @return 方書5
     */
    public RString get方書5() {
        return entity.getKatagakiSmall2();
    }

    /**
     * 代納人区分を取得します。
     *
     * @return 代納人区分
     */
    public RString get代納人区分() {
        return entity.getDainoKubunMei();
    }

    /**
     * 氏名1_1を取得します。
     *
     * @return 氏名1_1
     */
    public RString get氏名1_1() {
        return entity.getShimeiText();
    }

    /**
     * 氏名1_2を取得します。
     *
     * @return 氏名1_2
     */
    public RString get氏名1_2() {
        return entity.getShimei5();
    }

    /**
     * 氏名1_3を取得します。
     *
     * @return 氏名1_3
     */
    public RString get氏名1_3() {
        return entity.getShimei6();
    }

    /**
     * 氏名1_4を取得します。
     *
     * @return 氏名1_4
     */
    public RString get氏名1_4() {
        return entity.getShimeiSmall1();
    }

    /**
     * 氏名1_5を取得します。
     *
     * @return 氏名1_5
     */
    public RString get氏名1_5() {
        return entity.getShimeiSmall2();
    }

    /**
     * 氏名2_1を取得します。
     *
     * @return 氏名2_1
     */
    public RString get氏名2_1() {
        return entity.getSamabunShimeiText();
    }

    /**
     * 氏名2_2を取得します。
     *
     * @return 氏名2_2
     */
    public RString get氏名2_2() {
        return entity.getSamabunShimei1();
    }

    /**
     * 氏名2_3を取得します。
     *
     * @return 氏名2_3
     */
    public RString get氏名2_3() {
        return entity.getSamabunShimei2();
    }

    /**
     * 氏名2_4を取得します。
     *
     * @return 氏名2_4
     */
    public RString get氏名2_4() {
        return entity.getSamabunShimeiSmall1();
    }

    /**
     * 氏名2_5を取得します。
     *
     * @return 氏名2_5
     */
    public RString get氏名2_5() {
        return entity.getSamabunShimeiSmall2();
    }

    /**
     * 名称への敬称付与_1を取得します。
     *
     * @return 名称への敬称付与_1
     */
    public RString get名称への敬称付与_1() {
        return entity.getMeishoFuyo1();
    }

    /**
     * 名称への敬称付与_2を取得します。
     *
     * @return 名称への敬称付与_2
     */
    public RString get名称への敬称付与_2() {
        return entity.getMeishoFuyo2();
    }

    /**
     * 名称への敬称付与_3を取得します。
     *
     * @return 名称への敬称付与_3
     */
    public RString get名称への敬称付与_3() {
        return entity.getSamaBun1();
    }

    /**
     * 名称への敬称付与_4を取得します。
     *
     * @return 名称への敬称付与_4
     */
    public RString get名称への敬称付与_4() {
        return entity.getSamaBun2();
    }

    /**
     * 括弧_1を取得します。
     *
     * @return 括弧_1
     */
    public RString get括弧_1() {
        return entity.getKakkoLeft1();
    }

    /**
     * 括弧_2を取得します。
     *
     * @return 括弧_2
     */
    public RString get括弧_2() {
        return entity.getKakkoLeft2();
    }

    /**
     * 括弧_3を取得します。
     *
     * @return 括弧_3
     */
    public RString get括弧_3() {
        return entity.getKakkoRight1();
    }

    /**
     * 括弧_4を取得します。
     *
     * @return 括弧_4
     */
    public RString get括弧_4() {
        return entity.getKakkoRight2();
    }

    /**
     * カスタマバーコードを取得します。
     *
     * @return カスタマバーコード
     */
    public RString getカスタマバーコード() {
        return entity.getCustomerBarCode();
    }

    /**
     * 郵便番号_1を取得します。
     *
     * @return 郵便番号_1
     */
    public RString get郵便番号_1() {
        return entity.getYubinBango();
    }

    /**
     * 所在地を取得します。
     *
     * @return 所在地
     */
    public RString get所在地() {
        return entity.getShozaichi();
    }

    /**
     * 庁舎部署名を取得します。
     *
     * @return 庁舎部署名
     */
    public RString get庁舎部署名() {
        return entity.getChoshaBushoName();
    }

    /**
     * 担当名を取得します。
     *
     * @return 担当名
     */
    public RString get担当名() {
        return entity.getTantoName();
    }

    /**
     * 内線番号を取得します。
     *
     * @return 内線番号
     */
    public RString get内線番号() {
        return entity.getTelNo();
    }

    /**
     * 内線を取得します。
     *
     * @return 内線
     */
    public RString get内線() {
        return entity.getNaisenLabel();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return entity.getNaisenNo();
    }

    /**
     * Countを取得します。
     *
     * @return Count
     */
    public int getCount() {
        return entity.getPageCount();
    }
}
