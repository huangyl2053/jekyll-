/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.tokkiimages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特記事項連番の振り直し結果を保持します。
 */
public final class TokkiRembanRenumberingResult {

    private static final RString SEPARATOR = new RString(java.io.File.separator);
    private final NinteichosahyoTokkijikos tokkiJikos;
    private final Map</* 変更前連番 */ Integer, /* 変更後連番 */ Integer> editedRembans;

    private TokkiRembanRenumberingResult(Builder builder) {
        this.tokkiJikos = builder.tokkiJikos;
        this.editedRembans = builder.map;
    }

    /**
     * @param fromDirectory コピー元のディレクトリ
     * @param destDirectory コピー先のディレクトリ
     */
    public void copyImagesRenaming(RString fromDirectory, RString destDirectory) {
        final NinteiChosaTokkiJikou komoku = tokkiJikos.asTokkiJikoSet().iterator().next();
        Map<Integer, NinteichosahyoTokkijikos> mapByRemban = tokkiJikos.mapByRemban();
        for (Map.Entry<Integer, Integer> entry : this.editedRembans.entrySet()) {
            int before = entry.getKey();
            int after = entry.getValue();
            File.copy(composeImagePath(fromDirectory, komoku, before), composeImagePath(destDirectory, komoku, after));
            if (mapByRemban.get(before).containsMasked()) {
                File.copy(composeBakImagePath(fromDirectory, komoku, before), composeBakImagePath(destDirectory, komoku, after));
            }
        }
    }

    private static RString composeImagePath(RString directory, NinteiChosaTokkiJikou komoku, int remban) {
        return new RStringBuilder(directory).append(SEPARATOR).append(komoku.getComposedImageFileName(remban)).toRString();
    }

    private static RString composeBakImagePath(RString directory, NinteiChosaTokkiJikou komoku, int remban) {
        return new RStringBuilder(directory).append(SEPARATOR).append(komoku.getComposedBakImageFileName(remban)).toRString();
    }

    /**
     * @return 削除する要素（連番の変更ある物すべて）
     */
    public Iterable<NinteichosahyoTokkijiko> deleting() {
        List<NinteichosahyoTokkijiko> list = new ArrayList<>();
        Map<Integer, NinteichosahyoTokkijikos> mapByRemban = tokkiJikos.mapByRemban();
        for (Map.Entry<Integer, Integer> entry : this.editedRembans.entrySet()) {
            list.addAll(deleted(mapByRemban.get(entry.getKey())));
        }
        return list;
    }

    private static List<NinteichosahyoTokkijiko> deleted(NinteichosahyoTokkijikos tokkis) {
        List<NinteichosahyoTokkijiko> list = new ArrayList<>();
        for (NinteichosahyoTokkijiko tokki : tokkis) {
            list.add(tokki.deleted());
        }
        return list;
    }

    /**
     * @return 追加する要素
     */
    public Iterable<NinteichosahyoTokkijiko> adding() {
        List<NinteichosahyoTokkijiko> list = new ArrayList<>();
        Map<Integer, NinteichosahyoTokkijikos> mapByRemban = tokkiJikos.mapByRemban();
        for (Map.Entry<Integer, Integer> entry : this.editedRembans.entrySet()) {
            list.addAll(create(mapByRemban.get(entry.getKey()), entry.getValue()));
        }
        return list;
    }

    private static List<NinteichosahyoTokkijiko> create(NinteichosahyoTokkijikos tokkis, int afterRemban) {
        List<NinteichosahyoTokkijiko> list = new ArrayList<>();
        for (NinteichosahyoTokkijiko tokki : tokkis) {
            list.add(new NinteichosahyoTokkijiko(
                    tokki.get申請書管理番号(),
                    tokki.get認定調査依頼履歴番号(),
                    tokki.get認定調査特記事項番号(),
                    afterRemban,
                    tokki.get特記事項テキスト_イメージ区分(),
                    tokki.get原本マスク区分())
            );
        }
        return list;
    }

    /**
     * {@link TokkiRembanRenumberingResult}のビルダです。
     */
    public static final class Builder {

        private final NinteichosahyoTokkijikos tokkiJikos;
        private final Map<Integer, Integer> map;

        /**
         * @param tokkiJikos 対象の特記事項（項目でフィルター済みでない場合、それがと不正な動作の理由になります。）
         */
        public Builder(NinteichosahyoTokkijikos tokkiJikos) {
            this.tokkiJikos = tokkiJikos;
            this.map = new HashMap<>();
        }

        /**
         * @param before 変更前
         * @param after 変更後
         * @return ビルダのインスタンス
         */
        public Builder addIfNotSame(int before, int after) {
            if (before == after) {
                return this;
            }
            this.map.put(before, after);
            return this;
        }

        /**
         * @return {@link TokkiRembanRenumberingResult}
         */
        public TokkiRembanRenumberingResult build() {
            return new TokkiRembanRenumberingResult(this);
        }
    }
}
