/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.tokkiimages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoTokkijikos;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosatokkijikou.NinteiChosaTokkiJikou;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 特記事項連番の振り直し結果を保持します。
 */
public final class TokkiRembanRenumberingResult {

    private final NinteichosahyoTokkijikos tokkiJikos;
    private final Map</* 変更前連番 */ Integer, /* 変更後連番 */ Integer> editedRembans;

    private TokkiRembanRenumberingResult(Builder builder) {
        this.tokkiJikos = builder.tokkiJikos;
        this.editedRembans = Collections.unmodifiableMap(builder.map);
    }

    /**
     * @return 変更のあったイメージファイル名すべて
     */
    public List<FileNameBeforeAfter> getRenamedImageNames() {
        final NinteiChosaTokkiJikou komoku = tokkiJikos.asTokkiJikoSet().iterator().next();
        Map<Integer, NinteichosahyoTokkijikos> mapByRemban = tokkiJikos.mapByRemban();
        List<FileNameBeforeAfter> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : this.editedRembans.entrySet()) {
            int before = entry.getKey();
            int after = entry.getValue();
            list.add(FileNameBeforeAfter.effective(komoku, before, after));
            if (mapByRemban.get(before).containsMasked()) {
                list.add(FileNameBeforeAfter.backup(komoku, before, after));
            }
        }
        return list;
    }

    public static final class FileNameBeforeAfter {

        private static final RString SEPARATOR = new RString(java.io.File.separator);
        private final RString before;
        private final RString after;

        private FileNameBeforeAfter(RString before, RString after) {
            this.before = before;
            this.after = after;
        }

        private static FileNameBeforeAfter effective(NinteiChosaTokkiJikou komoku, int before, int after) {
            return new FileNameBeforeAfter(
                    komoku.getComposedImageFileName(before),
                    komoku.getComposedImageFileName(after)
            );
        }

        private static FileNameBeforeAfter backup(NinteiChosaTokkiJikou komoku, int before, int after) {
            return new FileNameBeforeAfter(
                    komoku.getComposedBakImageFileName(before),
                    komoku.getComposedBakImageFileName(after)
            );
        }

        /**
         * @return 変更前のイメージファイル名
         */
        public RString getBeforeFileName() {
            return this.before;
        }

        /**
         * @param directory ディレクトリのパス
         * @return 連番変更前の画像が指定のディレクトリに存在するとした場合のファイルパス文字列
         */
        public RString composeBeforePathAsIn(RString directory) {
            return new RStringBuilder(directory).append(SEPARATOR).append(before).toRString();
        }

        /**
         * @param directory ディレクトリのパス
         * @return 連番変更後の画像が指定のディレクトリに存在するとした場合のファイルパス文字列
         */
        public RString composeAfterPathAsIn(RString directory) {
            return new RStringBuilder(directory).append(SEPARATOR).append(after).toRString();
        }
    }

    /**
     * @return 削除する要素（連番の変更ある物すべて）
     */
    public Iterable<NinteichosahyoTokkijiko> targetsToDelete() {
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
    public Iterable<NinteichosahyoTokkijiko> targetsToAdd() {
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
