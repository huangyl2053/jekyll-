/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hihokenshashikakuhakko;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.config.ShiharaiHohoHenkoConfig;
import jp.co.ndensan.reams.db.dbz.business.hihokenshashikakuhakko.HihokenshaShikakuHakko;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.ShiharaiHohoHenkoShuryobunKisaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.DBACodeShubetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.HihokenshashoKofuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.code.shikaku.ShikakushashoKofuJiyu;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hihokenshashikakuhakko.HihokenshaShikakuHakkoHandler.KOFUJIYU_CHOKUZEN;
import static jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hihokenshashikakuhakko.HihokenshaShikakuHakkoHandler.KOFUJIYU_TEST;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMasterHelper;

/**
 * {@link HihokenshaShikakuHakkoDiv.発行証タイプ}毎に異なる振る舞いを定義しています。
 * <p>
 * 使用例:
 * <pre>
 *     IHakkoShoTypeBehavior behaviorByMode = HakkoShoTypeBehaviors.createBy(div.getMode_発行証タイプ());
 *     div.getDdlKofuJiyu().setDataSource(instance.create交付事由List(true));
 * </pre>
 * </p>
 *
 * @author N8187 久保田 英男
 */
final class HakkoShoTypeBehaviors {

    // TODO N8187 久保田 審査会意見の最大長(被保険者証の場合198文字)は被保険者証のソースデータクラスから取得するよう修正する。 2015/03/31。
    private static final int MAX_HIHOKENSHASHO = 198;
    // TODO N8187 久保田 審査会意見の最大長(資格者証の場合175文字)は資格者証のソースデータクラスから取得するよう修正する。 2015/03/31。
    private static final int MAX_SHIKAKUSHASHO = 175;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private HakkoShoTypeBehaviors() {
    }

    /**
     * 指定の{@link HihokenshaShikakuHakkoDiv.発行証タイプ}に該当する振る舞いを生成して返します。
     *
     * @param type {@link HihokenshaShikakuHakkoDiv.発行証タイプ}
     * @return 指定のmodeに対応する振る舞いを定義したインスタンス
     */
    static IHakkoShoTypeBehavior createBy(HihokenshaShikakuHakkoDiv.発行証タイプ type) {
        switch (type) {
            case 被保険者証:
                return new HihokenshaSho();
            case 資格者証:
                return new ShikakushaSho();
            default:
                throw new SystemException("定義されていないmodeが指定されました。");
        }
    }

    /**
     * {@link HihokenshaShikakuHakkoDiv.発行証タイプ}毎の振る舞いです。
     */
    interface IHakkoShoTypeBehavior {

        List<KeyValueDataSource> create交付事由List(boolean is直前履歴);

        int get審査会意見最大長();

        ShiharaiHohoHenkoShuryobunKisaiKubun load差止終了分記載区分();

        RString load差止記載文言();

        ShiharaiHohoHenkoShuryobunKisaiKubun load支払方法終了分記載区分();

        RString load支払方法記載文言();

        ShiharaiHohoHenkoShuryobunKisaiKubun load減額終了分記載区分();

        RString load減額記載文言();

        RString load支援事業者名称(RString 計画事業者名称, RString 委託先事業者名称);

    }

    /**
     * {@link HihokenshaShikakuHakkoDiv.発行証タイプ}が{@link HihokenshaShikakuHakkoDiv.発行証タイプ#被保険者証}の時の振る舞いです。
     */
    private static final class HihokenshaSho implements IHakkoShoTypeBehavior {

        @Override
        public List<KeyValueDataSource> create交付事由List(boolean is直前履歴) {
            List<KeyValueDataSource> result = new ArrayList<>();
            if (is直前履歴) {
                result.add(KOFUJIYU_CHOKUZEN);
                return result;
            }
            List<HihokenshashoKofuJiyu> 被保険者証交付事由List = CodeMasterHelper.getCode(DBACodeShubetsu.被保険者証交付事由);

            for (HihokenshashoKofuJiyu 交付事由 : 被保険者証交付事由List) {
                result.add(new KeyValueDataSource(交付事由.value().value(), 交付事由.getMeisho()));
            }
            result.add(KOFUJIYU_TEST);
            return result;
        }

        @Override
        public int get審査会意見最大長() {
            return MAX_HIHOKENSHASHO;
        }

        @Override
        public ShiharaiHohoHenkoShuryobunKisaiKubun load差止終了分記載区分() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_証表示差止_終了分記載区分();
        }

        @Override
        public RString load差止記載文言() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_証表示差止_記載文言();
        }

        @Override
        public ShiharaiHohoHenkoShuryobunKisaiKubun load支払方法終了分記載区分() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_証表示支払方法_終了分記載区分();
        }

        @Override
        public RString load支払方法記載文言() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_証表示支払方法_記載文言();
        }

        @Override
        public ShiharaiHohoHenkoShuryobunKisaiKubun load減額終了分記載区分() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_証表示減額_終了分記載区分();
        }

        @Override
        public RString load減額記載文言() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_証表示減額_記載文言();
        }

        @Override
        public RString load支援事業者名称(RString 計画事業者名称, RString 委託先事業者名称) {
            return new HihokenshaShikakuHakko().compose被保険者証支援事業者名称(計画事業者名称, 委託先事業者名称);
        }

    }

    /**
     * {@link HihokenshaShikakuHakkoDiv.発行証タイプ}が{@link HihokenshaShikakuHakkoDiv.発行証タイプ#資格者証}の時の振る舞いです。
     */
    private static final class ShikakushaSho implements IHakkoShoTypeBehavior {

        @Override
        public List<KeyValueDataSource> create交付事由List(boolean is直前履歴) {
            List<KeyValueDataSource> result = new ArrayList<>();
            List<ShikakushashoKofuJiyu> 資格者証交付事由List = CodeMasterHelper.getCode(DBACodeShubetsu.資格者証交付事由);

            for (ShikakushashoKofuJiyu 交付事由 : 資格者証交付事由List) {
                result.add(new KeyValueDataSource(交付事由.value().value(), 交付事由.getMeisho()));
            }
            result.add(KOFUJIYU_TEST);
            return result;
        }

        @Override
        public int get審査会意見最大長() {
            return MAX_SHIKAKUSHASHO;
        }

        @Override
        public ShiharaiHohoHenkoShuryobunKisaiKubun load差止終了分記載区分() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_資格者証表示差止_終了分記載区分();
        }

        @Override
        public RString load差止記載文言() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_資格者証表示差止_記載文言();
        }

        @Override
        public ShiharaiHohoHenkoShuryobunKisaiKubun load支払方法終了分記載区分() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_資格者証表示支払方法_終了分記載区分();
        }

        @Override
        public RString load支払方法記載文言() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_資格者証表示支払方法_記載文言();
        }

        @Override
        public ShiharaiHohoHenkoShuryobunKisaiKubun load減額終了分記載区分() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_資格者証表示減額_終了分記載区分();
        }

        @Override
        public RString load減額記載文言() {
            return new ShiharaiHohoHenkoConfig().get支払方法変更_資格者証表示減額_記載文言();
        }

        @Override
        public RString load支援事業者名称(RString 計画事業者名称, RString 委託先事業者名称) {
            return new HihokenshaShikakuHakko().compose資格者証支援事業者名称(計画事業者名称, 委託先事業者名称);
        }
    }
}
