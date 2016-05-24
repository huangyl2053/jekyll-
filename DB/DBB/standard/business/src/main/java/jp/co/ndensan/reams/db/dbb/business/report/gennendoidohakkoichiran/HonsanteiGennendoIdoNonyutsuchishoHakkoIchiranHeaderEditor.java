/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBBRP44002_1_保険料納入通知書（本算定現年度異動）発行一覧表 HeaderEditorです。
 *
 * 帳票項目定義は帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表と同じです。
 *
 * @reamsid_L DBB-0880-050 zhangrui
 */
public class HeaderEditor implements IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final RString 賦課年度;
    private final RString 帳票作成日時;
    private final RString 地方公共団体コード;
    private final RString 市町村名;

    private static final RString 所得段階名 = new RString("所得段階");

    private final RString 並び順の１件目;
    private final RString 並び順の２件目;
    private final RString 並び順の３件目;
    private final RString 並び順の４件目;
    private final RString 並び順の５件目;

    /**
     * コンストラクタです。
     *
     * @param inputEntity HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranInputEntity
     */
    public HeaderEditor(HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranInputEntity inputEntity) {
        this.編集後本算定通知書共通情報 = inputEntity.get編集後本算定通知書共通情報();
        this.賦課年度 = inputEntity.get賦課年度();
        this.帳票作成日時 = inputEntity.get帳票作成日時();
        this.地方公共団体コード = inputEntity.get地方公共団体コード();
        this.市町村名 = inputEntity.get市町村名();
        this.並び順の１件目 = inputEntity.get並び順の１件目();
        this.並び順の２件目 = inputEntity.get並び順の２件目();
        this.並び順の３件目 = inputEntity.get並び順の３件目();
        this.並び順の４件目 = inputEntity.get並び順の４件目();
        this.並び順の５件目 = inputEntity.get並び順の５件目();
    }

    @Override
    public NonyuTsuchIchiranSource edit(NonyuTsuchIchiranSource source) {
        EditedHonSanteiTsuchiShoKyotsu 共通情報 = 編集後本算定通知書共通情報;
        source.printTimeStamp = this.帳票作成日時;
        source.nendo = 賦課年度;
        source.hokenshaNo = 地方公共団体コード;
        source.hokenshaName = 市町村名;
        set出力帳票entities(source);
        if (共通情報.get表示コード() != null) {
            source.hyojicodeName1 = 共通情報.get表示コード().get表示コード名１();
            source.hyojicodeName2 = 共通情報.get表示コード().get表示コード名２();
            source.hyojicodeName3 = 共通情報.get表示コード().get表示コード名３();
        }
        source.shotokuDankaiTitle = 所得段階名;
        return source;
    }

    private void set出力帳票entities(NonyuTsuchIchiranSource source) {
        source.shutsuryokujun1 = 並び順の１件目;
        source.shutsuryokujun2 = 並び順の２件目;
        source.shutsuryokujun3 = 並び順の３件目;
        source.shutsuryokujun4 = 並び順の４件目;
        source.shutsuryokujun5 = 並び順の５件目;

    }

}
