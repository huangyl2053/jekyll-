/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.ur.urz.service.report.sourcebuilders;

import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha._NinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.parts.sofubutsuatesaki.shisetsu.ISofubutsuAtesakiForShisetsuSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.parts.sofubutsuatesaki.shisetsu._SofubutsuAtesakiForShisetsuSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.parts.toiawasesaki.IToiawasesakiSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.parts.toiawasesaki._ToiawasesakiSourceBuilderCreator;

/**
 * 帳票共通部品・雛形のSourceBuilderクラスのCreaterを取得するクラスです。<br/>
 * 業務で業務共通のSourceBuilderを取得する入口となります。 基本的には、このクラスから、業務共通のSourceBuilderを取得してください。
 *
 * <p>
 * ■関連クラス
 * <ul>
 * <li>{@link IToiawasesakiSourceBuilderCreator}</li>
 * <li>{@link INinshoshaSourceBuilderCreator}</li>
 * <li>{@link INofushoZenkiItemBuilderCreator}</li>
 * <li>{@link ITsuchishoAtesakiBuilderCreator}</li>
 * <li>{@link IKozaJohoSourceBuilderCreator}</li>
 * </ul>
 * </p>
 * <hr>
 *
 * @author n3309 後藤貴幸
 * @jpName 帳票ソースビルダーコレクション
 * @bizDomain 業務共通_帳票
 * @category 帳票共通
 * @subCategory 帳票ソースビルダー
 * @mainClass ○
 * @reference
 */
public final class ReportSourceBuilders {

    /**
     * インタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ReportSourceBuilders() {
    }

    /**
     * 問合せ先SourceBuilderのCreaterクラスを返します。
     *
     * @return 問合せ先SourceBuilderのCreaterクラスのインスタンス
     */
    public static IToiawasesakiSourceBuilderCreator toiawaseSourceBuilder() {
        return new _ToiawasesakiSourceBuilderCreator();
    }

    /**
     * 認証者SourceBuilderのCreaterクラスを返します。
     *
     * @return 認証者SourceBuilderのCreaterクラスのインスタンス
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
    public static INinshoshaSourceBuilderCreator ninshoshaSourceBuilder() {
        return new _NinshoshaSourceBuilderCreator();
    }

    /**
     * 送付物宛先（施設等用）ビルダークリエイターを作成します。
     *
     * @return 送付物宛先（施設等用）ビルダークリエイター
     */
    public static ISofubutsuAtesakiForShisetsuSourceBuilderCreator sofubutsuAtesakiForShisetsuSourceBuilder() {
        return new _SofubutsuAtesakiForShisetsuSourceBuilderCreator();
    }

}
