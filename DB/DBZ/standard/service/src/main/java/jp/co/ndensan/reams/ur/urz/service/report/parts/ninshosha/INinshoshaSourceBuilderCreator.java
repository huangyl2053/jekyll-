/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha;

import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * <p>
 * <h3>機能説明</h3>
 * 証明書・通知書等に印字する認証者・電子公印の帳票部品を取得します。<br />
 * 引数で指定された「業務コード」と「種別コード」と「発行日」を条件に、認証者情報を取得します。<br />
 * 認証者情報と引数で指定された「発行日」と「地方公共団体情報」から認証者ソースビルダーを生成します。<br />
 * 地方公共団体情報を引数にセットすることで、認証者に県名、市町村名が付与されます。<br />
 * （省略した場合は、直近の地方公共団体情報を取得します。）<br />
 * また、イメージファイルパスは帳票を作成する度に振られるパスでありUR側では取得できません。業務側で取得し設定してください。
 * </p>
 * <p>
 * <h3>利用方法</h3>
 * このインタフェースのインスタンスは、{@link ReportSourceBuilders#ninshoshaSourceBuilder()}で取得してください。
 * </p>
 * <p>
 * <h3>関連クラス</h3>
 * <ul>
 * <li>{@link INinshoshaSourceBuilder}</li>
 * <li>{@link jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSource}</li>
 * </ul>
 * </p>
 * <p>
 * <h3>関連テーブル</h3>
 * <ul>
 * <li>認証者・電子公印：{@link jp.co.ndensan.reams.ur.urz.entity.db.basic.ninshosha.UrT0008NinshoshaKoinControlEntity}</li>
 * <li>業務認証：{@link jp.co.ndensan.reams.ur.urz.entity.db.basic.ninshosha.UrT0019GyomuNinshoControlEntity}</li>
 * <li>認証者：{@link jp.co.ndensan.reams.ur.urz.entity.db.basic.ninshosha.UrT0009NinshoshaEntity}</li>
 * <li>電子公印：{@link jp.co.ndensan.reams.ur.urz.entity.db.basic.denshikoin.UrT0010DenshiKoinEntity}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author n3309 後藤貴幸
 * @jpName 認証者ソースビルダー作成インタフェース
 * @bizDomain 業務共通_帳票
 * @category 帳票部品
 * @subCategory 認証者
 * @mainClass ○
 * @reference CompNinshosha,認証者・電子公印利用ガイド
 * @deprecated
 * {@link jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder}
 * のインスタンスは、以下で取得してください。<br/>
 * {@link jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory}<br/>
 * その際に必要となるインスタンスは以下で取得してください。<br/>
 * <ul>
 * <li>認証者：{@link jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager}</li>
 * <li>地方公共団体：{@link jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder}</li>
 * </ul>
 * 帳票イメージフォルダパスに指定すべき値が、Businessパッケージからしか取得できなったためです。<br/>
 * ver1.7.0で削除する予定です
 */
public interface INinshoshaSourceBuilderCreator {

    /**
     * 認証者ソースビルダーのインスタンスを生成して返します。<br/>
     * このメソッドでは、業務コード、種別コード、発行年月日から認証者情報を取得します。
     * 発行日、地方公共団体、イメージファイルパスはnullを渡すことも可能です。
     *
     * @param gyomuCode 業務コード
     * @param shubetsuCode 種別コード
     * @param hakkoYMD 発行年月日
     * @param association 地方公共団体
     * @param imageFolderPath 帳票イメージフォルダパス
     * @param yakushokuMojiCount 役職名データ文字数
     *
     * @return 認証者ソースビルダー
     */
    INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode,
            RDate hakkoYMD, Association association, RString imageFolderPath, int yakushokuMojiCount);

    /**
     * 認証者ソースビルダーのインスタンスを生成して返します。<br/>
     * このメソッドでは、業務コード、種別コード、発行年月日から認証者情報を取得します。
     * 発行日、地方公共団体、イメージファイルパスはnullを渡すことも可能です。
     *
     * @param gyomuCode 業務コード
     * @param shubetsuCode 種別コード
     * @param hakkoYMD 発行年月日
     * @param association 地方公共団体
     * @param imageFolderPath 帳票イメージフォルダパス
     *
     * @return 認証者ソースビルダー
     */
    INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode,
            RDate hakkoYMD, Association association, RString imageFolderPath);

    /**
     * 認証者ソースビルダーのインスタンスを生成して返します。<br/>
     * このメソッドでは、業務コード、種別コード、発行年月日から認証者情報を取得します。 発行日、イメージファイルパスはnullを渡すことも可能です。
     *
     * @param gyomuCode 業務コード
     * @param shubetsuCode 種別コード
     * @param hakkoYMD 発行年月日
     * @param imageFolderPath 帳票イメージフォルダパス
     * @param yakushokuMojiCount 役職名データ文字数
     *
     * @return 認証者ソースビルダー
     */
    INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode, RDate hakkoYMD, RString imageFolderPath, int yakushokuMojiCount);

    /**
     * 認証者ソースビルダーのインスタンスを生成して返します。<br/>
     * このメソッドでは、業務コード、種別コード、発行年月日から認証者情報を取得します。 発行日、イメージファイルパスはnullを渡すことも可能です。
     *
     * @param gyomuCode 業務コード
     * @param shubetsuCode 種別コード
     * @param hakkoYMD 発行年月日
     * @param imageFolderPath 帳票イメージフォルダパス
     *
     * @return 認証者ソースビルダー
     */
    INinshoshaSourceBuilder create(GyomuCode gyomuCode, RString shubetsuCode, RDate hakkoYMD, RString imageFolderPath);
}
