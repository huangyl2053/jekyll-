package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe8020001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblShinchokuKakunin のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblShinchokuKakuninDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celShinchokuHeader")
    private celShinchokuHeaderAttblShinchokuKakunin celShinchokuHeader;
    @JsonProperty("celShinseijiShori")
    private celShinseijiShoriAttblShinchokuKakunin celShinseijiShori;
    @JsonProperty("celChosaIrai")
    private celChosaIraiAttblShinchokuKakunin celChosaIrai;
    @JsonProperty("celKanryoYoteibi")
    private celKanryoYoteibiAttblShinchokuKakunin celKanryoYoteibi;
    @JsonProperty("celShinseijiShoriYoteibi")
    private celShinseijiShoriYoteibiAttblShinchokuKakunin celShinseijiShoriYoteibi;
    @JsonProperty("celChosaIraiYoteibi")
    private celChosaIraiYoteibiAttblShinchokuKakunin celChosaIraiYoteibi;
    @JsonProperty("celKanryoJissekibi")
    private celKanryoJissekibiAttblShinchokuKakunin celKanryoJissekibi;
    @JsonProperty("celShinseijiShoriJissekibi")
    private celShinseijiShoriJissekibiAttblShinchokuKakunin celShinseijiShoriJissekibi;
    @JsonProperty("celChosaIraiJissekibi")
    private celChosaIraiJissekibiAttblShinchokuKakunin celChosaIraiJissekibi;
    @JsonProperty("celChosahyoNyushu")
    private celChosahyoNyushuAttblShinchokuKakunin celChosahyoNyushu;
    @JsonProperty("celIkenshoIrai")
    private celIkenshoIraiAttblShinchokuKakunin celIkenshoIrai;
    @JsonProperty("celIkenshoNyushu")
    private celIkenshoNyushuAttblShinchokuKakunin celIkenshoNyushu;
    @JsonProperty("celIchijiHantei")
    private celIchijiHanteiAttblShinchokuKakunin celIchijiHantei;
    @JsonProperty("celShinsakaiToroku")
    private celShinsakaiTorokuAttblShinchokuKakunin celShinsakaiToroku;
    @JsonProperty("celNijiHantei")
    private celNijiHanteiAttblShinchokuKakunin celNijiHantei;
    @JsonProperty("celHanteigoShori")
    private celHanteigoShoriAttblShinchokuKakunin celHanteigoShori;
    @JsonProperty("celChosahyoNyushuYoteibi")
    private celChosahyoNyushuYoteibiAttblShinchokuKakunin celChosahyoNyushuYoteibi;
    @JsonProperty("celIkenshoIraiYoteibi")
    private celIkenshoIraiYoteibiAttblShinchokuKakunin celIkenshoIraiYoteibi;
    @JsonProperty("celIkenshoNyushuYoteibi")
    private celIkenshoNyushuYoteibiAttblShinchokuKakunin celIkenshoNyushuYoteibi;
    @JsonProperty("celIchijiHanteiYoteibi")
    private celIchijiHanteiYoteibiAttblShinchokuKakunin celIchijiHanteiYoteibi;
    @JsonProperty("celShinsakaiTorokuYoteibi")
    private celShinsakaiTorokuYoteibiAttblShinchokuKakunin celShinsakaiTorokuYoteibi;
    @JsonProperty("celNijiHanteiYoteibi")
    private celNijiHanteiYoteibiAttblShinchokuKakunin celNijiHanteiYoteibi;
    @JsonProperty("celHanteigoShoriYoteibi")
    private celHanteigoShoriYoteibiAttblShinchokuKakunin celHanteigoShoriYoteibi;
    @JsonProperty("celChosahyoNyushuJissekibi")
    private celChosahyoNyushuJissekibiAttblShinchokuKakunin celChosahyoNyushuJissekibi;
    @JsonProperty("celIkenshoIraiJissekibi")
    private celIkenshoIraiJissekibiAttblShinchokuKakunin celIkenshoIraiJissekibi;
    @JsonProperty("celIkenshoNyushuJissekibi")
    private celIkenshoNyushuJissekibiAttblShinchokuKakunin celIkenshoNyushuJissekibi;
    @JsonProperty("celIchijiHanteiJissekibi")
    private celIchijiHanteiJissekibiAttblShinchokuKakunin celIchijiHanteiJissekibi;
    @JsonProperty("celShinsakaiTorokuJissekibi")
    private celShinsakaiTorokuJissekibiAttblShinchokuKakunin celShinsakaiTorokuJissekibi;
    @JsonProperty("celNijiHanteiJissekibi")
    private celNijiHanteiJissekibiAttblShinchokuKakunin celNijiHanteiJissekibi;
    @JsonProperty("celHanteigoShoriJissekibi")
    private celHanteigoShoriJissekibiAttblShinchokuKakunin celHanteigoShoriJissekibi;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblShinchokuHeader() {
        return this.celShinchokuHeader.getLblShinchokuHeader();
    }

    @JsonIgnore
    public Label getLblShinseijiShori() {
        return this.celShinseijiShori.getLblShinseijiShori();
    }

    @JsonIgnore
    public Label getLblChosaIrai() {
        return this.celChosaIrai.getLblChosaIrai();
    }

    @JsonIgnore
    public Label getLblKanryoYoteibi() {
        return this.celKanryoYoteibi.getLblKanryoYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseijiShoriYoteibi() {
        return this.celShinseijiShoriYoteibi.getTxtShinseijiShoriYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiYoteibi() {
        return this.celChosaIraiYoteibi.getTxtChosaIraiYoteibi();
    }

    @JsonIgnore
    public Label getLblKanryoJissekibi() {
        return this.celKanryoJissekibi.getLblKanryoJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseijiShoriJissekibi() {
        return this.celShinseijiShoriJissekibi.getTxtShinseijiShoriJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiJissekibi() {
        return this.celChosaIraiJissekibi.getTxtChosaIraiJissekibi();
    }

    @JsonIgnore
    public Label getLblChosahyoNyushu() {
        return this.celChosahyoNyushu.getLblChosahyoNyushu();
    }

    @JsonIgnore
    public Label getLblIkenshoIrai() {
        return this.celIkenshoIrai.getLblIkenshoIrai();
    }

    @JsonIgnore
    public Label getLblIkenshoNyushu() {
        return this.celIkenshoNyushu.getLblIkenshoNyushu();
    }

    @JsonIgnore
    public Label getLblIchijiHantei() {
        return this.celIchijiHantei.getLblIchijiHantei();
    }

    @JsonIgnore
    public Label getLblShinsakaiToroku() {
        return this.celShinsakaiToroku.getLblShinsakaiToroku();
    }

    @JsonIgnore
    public Label getLblNijiHantei() {
        return this.celNijiHantei.getLblNijiHantei();
    }

    @JsonIgnore
    public Label getLblHanteigoShori() {
        return this.celHanteigoShori.getLblHanteigoShori();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosahyoNyushuYoteibi() {
        return this.celChosahyoNyushuYoteibi.getTxtChosahyoNyushuYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraiYoteibi() {
        return this.celIkenshoIraiYoteibi.getTxtIkenshoIraiYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoNyushuYoteibi() {
        return this.celIkenshoNyushuYoteibi.getTxtIkenshoNyushuYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiYoteibi() {
        return this.celIchijiHanteiYoteibi.getTxtIchijiHanteiYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiTorokuYoteibi() {
        return this.celShinsakaiTorokuYoteibi.getTxtShinsakaiTorokuYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtNijiHanteiYoteibi() {
        return this.celNijiHanteiYoteibi.getTxtNijiHanteiYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtHanteigoShoriYoteibi() {
        return this.celHanteigoShoriYoteibi.getTxtHanteigoShoriYoteibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtChosahyoNyushuJissekibi() {
        return this.celChosahyoNyushuJissekibi.getTxtChosahyoNyushuJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraiJissekibi() {
        return this.celIkenshoIraiJissekibi.getTxtIkenshoIraiJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoNyushuJissekibi() {
        return this.celIkenshoNyushuJissekibi.getTxtIkenshoNyushuJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtIchijiHanteiJissekibi() {
        return this.celIchijiHanteiJissekibi.getTxtIchijiHanteiJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiTorokuJissekibi() {
        return this.celShinsakaiTorokuJissekibi.getTxtShinsakaiTorokuJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtNijiHanteiJissekibi() {
        return this.celNijiHanteiJissekibi.getTxtNijiHanteiJissekibi();
    }

    @JsonIgnore
    public TextBoxDate getTxtHanteigoShoriJissekibi() {
        return this.celHanteigoShoriJissekibi.getTxtHanteigoShoriJissekibi();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celShinchokuHeader")
    private celShinchokuHeaderAttblShinchokuKakunin getCelShinchokuHeader() {
        return celShinchokuHeader;
    }

    @JsonProperty("celShinchokuHeader")
    private void setCelShinchokuHeader(celShinchokuHeaderAttblShinchokuKakunin celShinchokuHeader) {
        this.celShinchokuHeader=celShinchokuHeader;
    }

    @JsonProperty("celShinseijiShori")
    private celShinseijiShoriAttblShinchokuKakunin getCelShinseijiShori() {
        return celShinseijiShori;
    }

    @JsonProperty("celShinseijiShori")
    private void setCelShinseijiShori(celShinseijiShoriAttblShinchokuKakunin celShinseijiShori) {
        this.celShinseijiShori=celShinseijiShori;
    }

    @JsonProperty("celChosaIrai")
    private celChosaIraiAttblShinchokuKakunin getCelChosaIrai() {
        return celChosaIrai;
    }

    @JsonProperty("celChosaIrai")
    private void setCelChosaIrai(celChosaIraiAttblShinchokuKakunin celChosaIrai) {
        this.celChosaIrai=celChosaIrai;
    }

    @JsonProperty("celKanryoYoteibi")
    private celKanryoYoteibiAttblShinchokuKakunin getCelKanryoYoteibi() {
        return celKanryoYoteibi;
    }

    @JsonProperty("celKanryoYoteibi")
    private void setCelKanryoYoteibi(celKanryoYoteibiAttblShinchokuKakunin celKanryoYoteibi) {
        this.celKanryoYoteibi=celKanryoYoteibi;
    }

    @JsonProperty("celShinseijiShoriYoteibi")
    private celShinseijiShoriYoteibiAttblShinchokuKakunin getCelShinseijiShoriYoteibi() {
        return celShinseijiShoriYoteibi;
    }

    @JsonProperty("celShinseijiShoriYoteibi")
    private void setCelShinseijiShoriYoteibi(celShinseijiShoriYoteibiAttblShinchokuKakunin celShinseijiShoriYoteibi) {
        this.celShinseijiShoriYoteibi=celShinseijiShoriYoteibi;
    }

    @JsonProperty("celChosaIraiYoteibi")
    private celChosaIraiYoteibiAttblShinchokuKakunin getCelChosaIraiYoteibi() {
        return celChosaIraiYoteibi;
    }

    @JsonProperty("celChosaIraiYoteibi")
    private void setCelChosaIraiYoteibi(celChosaIraiYoteibiAttblShinchokuKakunin celChosaIraiYoteibi) {
        this.celChosaIraiYoteibi=celChosaIraiYoteibi;
    }

    @JsonProperty("celKanryoJissekibi")
    private celKanryoJissekibiAttblShinchokuKakunin getCelKanryoJissekibi() {
        return celKanryoJissekibi;
    }

    @JsonProperty("celKanryoJissekibi")
    private void setCelKanryoJissekibi(celKanryoJissekibiAttblShinchokuKakunin celKanryoJissekibi) {
        this.celKanryoJissekibi=celKanryoJissekibi;
    }

    @JsonProperty("celShinseijiShoriJissekibi")
    private celShinseijiShoriJissekibiAttblShinchokuKakunin getCelShinseijiShoriJissekibi() {
        return celShinseijiShoriJissekibi;
    }

    @JsonProperty("celShinseijiShoriJissekibi")
    private void setCelShinseijiShoriJissekibi(celShinseijiShoriJissekibiAttblShinchokuKakunin celShinseijiShoriJissekibi) {
        this.celShinseijiShoriJissekibi=celShinseijiShoriJissekibi;
    }

    @JsonProperty("celChosaIraiJissekibi")
    private celChosaIraiJissekibiAttblShinchokuKakunin getCelChosaIraiJissekibi() {
        return celChosaIraiJissekibi;
    }

    @JsonProperty("celChosaIraiJissekibi")
    private void setCelChosaIraiJissekibi(celChosaIraiJissekibiAttblShinchokuKakunin celChosaIraiJissekibi) {
        this.celChosaIraiJissekibi=celChosaIraiJissekibi;
    }

    @JsonProperty("celChosahyoNyushu")
    private celChosahyoNyushuAttblShinchokuKakunin getCelChosahyoNyushu() {
        return celChosahyoNyushu;
    }

    @JsonProperty("celChosahyoNyushu")
    private void setCelChosahyoNyushu(celChosahyoNyushuAttblShinchokuKakunin celChosahyoNyushu) {
        this.celChosahyoNyushu=celChosahyoNyushu;
    }

    @JsonProperty("celIkenshoIrai")
    private celIkenshoIraiAttblShinchokuKakunin getCelIkenshoIrai() {
        return celIkenshoIrai;
    }

    @JsonProperty("celIkenshoIrai")
    private void setCelIkenshoIrai(celIkenshoIraiAttblShinchokuKakunin celIkenshoIrai) {
        this.celIkenshoIrai=celIkenshoIrai;
    }

    @JsonProperty("celIkenshoNyushu")
    private celIkenshoNyushuAttblShinchokuKakunin getCelIkenshoNyushu() {
        return celIkenshoNyushu;
    }

    @JsonProperty("celIkenshoNyushu")
    private void setCelIkenshoNyushu(celIkenshoNyushuAttblShinchokuKakunin celIkenshoNyushu) {
        this.celIkenshoNyushu=celIkenshoNyushu;
    }

    @JsonProperty("celIchijiHantei")
    private celIchijiHanteiAttblShinchokuKakunin getCelIchijiHantei() {
        return celIchijiHantei;
    }

    @JsonProperty("celIchijiHantei")
    private void setCelIchijiHantei(celIchijiHanteiAttblShinchokuKakunin celIchijiHantei) {
        this.celIchijiHantei=celIchijiHantei;
    }

    @JsonProperty("celShinsakaiToroku")
    private celShinsakaiTorokuAttblShinchokuKakunin getCelShinsakaiToroku() {
        return celShinsakaiToroku;
    }

    @JsonProperty("celShinsakaiToroku")
    private void setCelShinsakaiToroku(celShinsakaiTorokuAttblShinchokuKakunin celShinsakaiToroku) {
        this.celShinsakaiToroku=celShinsakaiToroku;
    }

    @JsonProperty("celNijiHantei")
    private celNijiHanteiAttblShinchokuKakunin getCelNijiHantei() {
        return celNijiHantei;
    }

    @JsonProperty("celNijiHantei")
    private void setCelNijiHantei(celNijiHanteiAttblShinchokuKakunin celNijiHantei) {
        this.celNijiHantei=celNijiHantei;
    }

    @JsonProperty("celHanteigoShori")
    private celHanteigoShoriAttblShinchokuKakunin getCelHanteigoShori() {
        return celHanteigoShori;
    }

    @JsonProperty("celHanteigoShori")
    private void setCelHanteigoShori(celHanteigoShoriAttblShinchokuKakunin celHanteigoShori) {
        this.celHanteigoShori=celHanteigoShori;
    }

    @JsonProperty("celChosahyoNyushuYoteibi")
    private celChosahyoNyushuYoteibiAttblShinchokuKakunin getCelChosahyoNyushuYoteibi() {
        return celChosahyoNyushuYoteibi;
    }

    @JsonProperty("celChosahyoNyushuYoteibi")
    private void setCelChosahyoNyushuYoteibi(celChosahyoNyushuYoteibiAttblShinchokuKakunin celChosahyoNyushuYoteibi) {
        this.celChosahyoNyushuYoteibi=celChosahyoNyushuYoteibi;
    }

    @JsonProperty("celIkenshoIraiYoteibi")
    private celIkenshoIraiYoteibiAttblShinchokuKakunin getCelIkenshoIraiYoteibi() {
        return celIkenshoIraiYoteibi;
    }

    @JsonProperty("celIkenshoIraiYoteibi")
    private void setCelIkenshoIraiYoteibi(celIkenshoIraiYoteibiAttblShinchokuKakunin celIkenshoIraiYoteibi) {
        this.celIkenshoIraiYoteibi=celIkenshoIraiYoteibi;
    }

    @JsonProperty("celIkenshoNyushuYoteibi")
    private celIkenshoNyushuYoteibiAttblShinchokuKakunin getCelIkenshoNyushuYoteibi() {
        return celIkenshoNyushuYoteibi;
    }

    @JsonProperty("celIkenshoNyushuYoteibi")
    private void setCelIkenshoNyushuYoteibi(celIkenshoNyushuYoteibiAttblShinchokuKakunin celIkenshoNyushuYoteibi) {
        this.celIkenshoNyushuYoteibi=celIkenshoNyushuYoteibi;
    }

    @JsonProperty("celIchijiHanteiYoteibi")
    private celIchijiHanteiYoteibiAttblShinchokuKakunin getCelIchijiHanteiYoteibi() {
        return celIchijiHanteiYoteibi;
    }

    @JsonProperty("celIchijiHanteiYoteibi")
    private void setCelIchijiHanteiYoteibi(celIchijiHanteiYoteibiAttblShinchokuKakunin celIchijiHanteiYoteibi) {
        this.celIchijiHanteiYoteibi=celIchijiHanteiYoteibi;
    }

    @JsonProperty("celShinsakaiTorokuYoteibi")
    private celShinsakaiTorokuYoteibiAttblShinchokuKakunin getCelShinsakaiTorokuYoteibi() {
        return celShinsakaiTorokuYoteibi;
    }

    @JsonProperty("celShinsakaiTorokuYoteibi")
    private void setCelShinsakaiTorokuYoteibi(celShinsakaiTorokuYoteibiAttblShinchokuKakunin celShinsakaiTorokuYoteibi) {
        this.celShinsakaiTorokuYoteibi=celShinsakaiTorokuYoteibi;
    }

    @JsonProperty("celNijiHanteiYoteibi")
    private celNijiHanteiYoteibiAttblShinchokuKakunin getCelNijiHanteiYoteibi() {
        return celNijiHanteiYoteibi;
    }

    @JsonProperty("celNijiHanteiYoteibi")
    private void setCelNijiHanteiYoteibi(celNijiHanteiYoteibiAttblShinchokuKakunin celNijiHanteiYoteibi) {
        this.celNijiHanteiYoteibi=celNijiHanteiYoteibi;
    }

    @JsonProperty("celHanteigoShoriYoteibi")
    private celHanteigoShoriYoteibiAttblShinchokuKakunin getCelHanteigoShoriYoteibi() {
        return celHanteigoShoriYoteibi;
    }

    @JsonProperty("celHanteigoShoriYoteibi")
    private void setCelHanteigoShoriYoteibi(celHanteigoShoriYoteibiAttblShinchokuKakunin celHanteigoShoriYoteibi) {
        this.celHanteigoShoriYoteibi=celHanteigoShoriYoteibi;
    }

    @JsonProperty("celChosahyoNyushuJissekibi")
    private celChosahyoNyushuJissekibiAttblShinchokuKakunin getCelChosahyoNyushuJissekibi() {
        return celChosahyoNyushuJissekibi;
    }

    @JsonProperty("celChosahyoNyushuJissekibi")
    private void setCelChosahyoNyushuJissekibi(celChosahyoNyushuJissekibiAttblShinchokuKakunin celChosahyoNyushuJissekibi) {
        this.celChosahyoNyushuJissekibi=celChosahyoNyushuJissekibi;
    }

    @JsonProperty("celIkenshoIraiJissekibi")
    private celIkenshoIraiJissekibiAttblShinchokuKakunin getCelIkenshoIraiJissekibi() {
        return celIkenshoIraiJissekibi;
    }

    @JsonProperty("celIkenshoIraiJissekibi")
    private void setCelIkenshoIraiJissekibi(celIkenshoIraiJissekibiAttblShinchokuKakunin celIkenshoIraiJissekibi) {
        this.celIkenshoIraiJissekibi=celIkenshoIraiJissekibi;
    }

    @JsonProperty("celIkenshoNyushuJissekibi")
    private celIkenshoNyushuJissekibiAttblShinchokuKakunin getCelIkenshoNyushuJissekibi() {
        return celIkenshoNyushuJissekibi;
    }

    @JsonProperty("celIkenshoNyushuJissekibi")
    private void setCelIkenshoNyushuJissekibi(celIkenshoNyushuJissekibiAttblShinchokuKakunin celIkenshoNyushuJissekibi) {
        this.celIkenshoNyushuJissekibi=celIkenshoNyushuJissekibi;
    }

    @JsonProperty("celIchijiHanteiJissekibi")
    private celIchijiHanteiJissekibiAttblShinchokuKakunin getCelIchijiHanteiJissekibi() {
        return celIchijiHanteiJissekibi;
    }

    @JsonProperty("celIchijiHanteiJissekibi")
    private void setCelIchijiHanteiJissekibi(celIchijiHanteiJissekibiAttblShinchokuKakunin celIchijiHanteiJissekibi) {
        this.celIchijiHanteiJissekibi=celIchijiHanteiJissekibi;
    }

    @JsonProperty("celShinsakaiTorokuJissekibi")
    private celShinsakaiTorokuJissekibiAttblShinchokuKakunin getCelShinsakaiTorokuJissekibi() {
        return celShinsakaiTorokuJissekibi;
    }

    @JsonProperty("celShinsakaiTorokuJissekibi")
    private void setCelShinsakaiTorokuJissekibi(celShinsakaiTorokuJissekibiAttblShinchokuKakunin celShinsakaiTorokuJissekibi) {
        this.celShinsakaiTorokuJissekibi=celShinsakaiTorokuJissekibi;
    }

    @JsonProperty("celNijiHanteiJissekibi")
    private celNijiHanteiJissekibiAttblShinchokuKakunin getCelNijiHanteiJissekibi() {
        return celNijiHanteiJissekibi;
    }

    @JsonProperty("celNijiHanteiJissekibi")
    private void setCelNijiHanteiJissekibi(celNijiHanteiJissekibiAttblShinchokuKakunin celNijiHanteiJissekibi) {
        this.celNijiHanteiJissekibi=celNijiHanteiJissekibi;
    }

    @JsonProperty("celHanteigoShoriJissekibi")
    private celHanteigoShoriJissekibiAttblShinchokuKakunin getCelHanteigoShoriJissekibi() {
        return celHanteigoShoriJissekibi;
    }

    @JsonProperty("celHanteigoShoriJissekibi")
    private void setCelHanteigoShoriJissekibi(celHanteigoShoriJissekibiAttblShinchokuKakunin celHanteigoShoriJissekibi) {
        this.celHanteigoShoriJissekibi=celHanteigoShoriJissekibi;
    }

}
/**
 * celShinchokuHeader のクラスファイル 
 * 
 * @author 自動生成
 */
class celShinchokuHeaderAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblShinchokuHeader")
    private Label lblShinchokuHeader;

    @JsonProperty("lblShinchokuHeader")
    public Label getLblShinchokuHeader() {
        return lblShinchokuHeader;
    }

    @JsonProperty("lblShinchokuHeader")
    public void setLblShinchokuHeader(Label lblShinchokuHeader) {
        this.lblShinchokuHeader=lblShinchokuHeader;
    }

}
/**
 * celShinseijiShori のクラスファイル 
 * 
 * @author 自動生成
 */
class celShinseijiShoriAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblShinseijiShori")
    private Label lblShinseijiShori;

    @JsonProperty("lblShinseijiShori")
    public Label getLblShinseijiShori() {
        return lblShinseijiShori;
    }

    @JsonProperty("lblShinseijiShori")
    public void setLblShinseijiShori(Label lblShinseijiShori) {
        this.lblShinseijiShori=lblShinseijiShori;
    }

}
/**
 * celChosaIrai のクラスファイル 
 * 
 * @author 自動生成
 */
class celChosaIraiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblChosaIrai")
    private Label lblChosaIrai;

    @JsonProperty("lblChosaIrai")
    public Label getLblChosaIrai() {
        return lblChosaIrai;
    }

    @JsonProperty("lblChosaIrai")
    public void setLblChosaIrai(Label lblChosaIrai) {
        this.lblChosaIrai=lblChosaIrai;
    }

}
/**
 * celKanryoYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celKanryoYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblKanryoYoteibi")
    private Label lblKanryoYoteibi;

    @JsonProperty("lblKanryoYoteibi")
    public Label getLblKanryoYoteibi() {
        return lblKanryoYoteibi;
    }

    @JsonProperty("lblKanryoYoteibi")
    public void setLblKanryoYoteibi(Label lblKanryoYoteibi) {
        this.lblKanryoYoteibi=lblKanryoYoteibi;
    }

}
/**
 * celShinseijiShoriYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celShinseijiShoriYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtShinseijiShoriYoteibi")
    private TextBoxDate txtShinseijiShoriYoteibi;

    @JsonProperty("txtShinseijiShoriYoteibi")
    public TextBoxDate getTxtShinseijiShoriYoteibi() {
        return txtShinseijiShoriYoteibi;
    }

    @JsonProperty("txtShinseijiShoriYoteibi")
    public void setTxtShinseijiShoriYoteibi(TextBoxDate txtShinseijiShoriYoteibi) {
        this.txtShinseijiShoriYoteibi=txtShinseijiShoriYoteibi;
    }

}
/**
 * celChosaIraiYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celChosaIraiYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtChosaIraiYoteibi")
    private TextBoxDate txtChosaIraiYoteibi;

    @JsonProperty("txtChosaIraiYoteibi")
    public TextBoxDate getTxtChosaIraiYoteibi() {
        return txtChosaIraiYoteibi;
    }

    @JsonProperty("txtChosaIraiYoteibi")
    public void setTxtChosaIraiYoteibi(TextBoxDate txtChosaIraiYoteibi) {
        this.txtChosaIraiYoteibi=txtChosaIraiYoteibi;
    }

}
/**
 * celKanryoJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celKanryoJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblKanryoJissekibi")
    private Label lblKanryoJissekibi;

    @JsonProperty("lblKanryoJissekibi")
    public Label getLblKanryoJissekibi() {
        return lblKanryoJissekibi;
    }

    @JsonProperty("lblKanryoJissekibi")
    public void setLblKanryoJissekibi(Label lblKanryoJissekibi) {
        this.lblKanryoJissekibi=lblKanryoJissekibi;
    }

}
/**
 * celShinseijiShoriJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celShinseijiShoriJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtShinseijiShoriJissekibi")
    private TextBoxDate txtShinseijiShoriJissekibi;

    @JsonProperty("txtShinseijiShoriJissekibi")
    public TextBoxDate getTxtShinseijiShoriJissekibi() {
        return txtShinseijiShoriJissekibi;
    }

    @JsonProperty("txtShinseijiShoriJissekibi")
    public void setTxtShinseijiShoriJissekibi(TextBoxDate txtShinseijiShoriJissekibi) {
        this.txtShinseijiShoriJissekibi=txtShinseijiShoriJissekibi;
    }

}
/**
 * celChosaIraiJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celChosaIraiJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtChosaIraiJissekibi")
    private TextBoxDate txtChosaIraiJissekibi;

    @JsonProperty("txtChosaIraiJissekibi")
    public TextBoxDate getTxtChosaIraiJissekibi() {
        return txtChosaIraiJissekibi;
    }

    @JsonProperty("txtChosaIraiJissekibi")
    public void setTxtChosaIraiJissekibi(TextBoxDate txtChosaIraiJissekibi) {
        this.txtChosaIraiJissekibi=txtChosaIraiJissekibi;
    }

}
/**
 * celChosahyoNyushu のクラスファイル 
 * 
 * @author 自動生成
 */
class celChosahyoNyushuAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblChosahyoNyushu")
    private Label lblChosahyoNyushu;

    @JsonProperty("lblChosahyoNyushu")
    public Label getLblChosahyoNyushu() {
        return lblChosahyoNyushu;
    }

    @JsonProperty("lblChosahyoNyushu")
    public void setLblChosahyoNyushu(Label lblChosahyoNyushu) {
        this.lblChosahyoNyushu=lblChosahyoNyushu;
    }

}
/**
 * celIkenshoIrai のクラスファイル 
 * 
 * @author 自動生成
 */
class celIkenshoIraiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblIkenshoIrai")
    private Label lblIkenshoIrai;

    @JsonProperty("lblIkenshoIrai")
    public Label getLblIkenshoIrai() {
        return lblIkenshoIrai;
    }

    @JsonProperty("lblIkenshoIrai")
    public void setLblIkenshoIrai(Label lblIkenshoIrai) {
        this.lblIkenshoIrai=lblIkenshoIrai;
    }

}
/**
 * celIkenshoNyushu のクラスファイル 
 * 
 * @author 自動生成
 */
class celIkenshoNyushuAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblIkenshoNyushu")
    private Label lblIkenshoNyushu;

    @JsonProperty("lblIkenshoNyushu")
    public Label getLblIkenshoNyushu() {
        return lblIkenshoNyushu;
    }

    @JsonProperty("lblIkenshoNyushu")
    public void setLblIkenshoNyushu(Label lblIkenshoNyushu) {
        this.lblIkenshoNyushu=lblIkenshoNyushu;
    }

}
/**
 * celIchijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
class celIchijiHanteiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblIchijiHantei")
    private Label lblIchijiHantei;

    @JsonProperty("lblIchijiHantei")
    public Label getLblIchijiHantei() {
        return lblIchijiHantei;
    }

    @JsonProperty("lblIchijiHantei")
    public void setLblIchijiHantei(Label lblIchijiHantei) {
        this.lblIchijiHantei=lblIchijiHantei;
    }

}
/**
 * celShinsakaiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
class celShinsakaiTorokuAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblShinsakaiToroku")
    private Label lblShinsakaiToroku;

    @JsonProperty("lblShinsakaiToroku")
    public Label getLblShinsakaiToroku() {
        return lblShinsakaiToroku;
    }

    @JsonProperty("lblShinsakaiToroku")
    public void setLblShinsakaiToroku(Label lblShinsakaiToroku) {
        this.lblShinsakaiToroku=lblShinsakaiToroku;
    }

}
/**
 * celNijiHantei のクラスファイル 
 * 
 * @author 自動生成
 */
class celNijiHanteiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblNijiHantei")
    private Label lblNijiHantei;

    @JsonProperty("lblNijiHantei")
    public Label getLblNijiHantei() {
        return lblNijiHantei;
    }

    @JsonProperty("lblNijiHantei")
    public void setLblNijiHantei(Label lblNijiHantei) {
        this.lblNijiHantei=lblNijiHantei;
    }

}
/**
 * celHanteigoShori のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanteigoShoriAttblShinchokuKakunin extends TableCell {
    @JsonProperty("lblHanteigoShori")
    private Label lblHanteigoShori;

    @JsonProperty("lblHanteigoShori")
    public Label getLblHanteigoShori() {
        return lblHanteigoShori;
    }

    @JsonProperty("lblHanteigoShori")
    public void setLblHanteigoShori(Label lblHanteigoShori) {
        this.lblHanteigoShori=lblHanteigoShori;
    }

}
/**
 * celChosahyoNyushuYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celChosahyoNyushuYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtChosahyoNyushuYoteibi")
    private TextBoxDate txtChosahyoNyushuYoteibi;

    @JsonProperty("txtChosahyoNyushuYoteibi")
    public TextBoxDate getTxtChosahyoNyushuYoteibi() {
        return txtChosahyoNyushuYoteibi;
    }

    @JsonProperty("txtChosahyoNyushuYoteibi")
    public void setTxtChosahyoNyushuYoteibi(TextBoxDate txtChosahyoNyushuYoteibi) {
        this.txtChosahyoNyushuYoteibi=txtChosahyoNyushuYoteibi;
    }

}
/**
 * celIkenshoIraiYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celIkenshoIraiYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtIkenshoIraiYoteibi")
    private TextBoxDate txtIkenshoIraiYoteibi;

    @JsonProperty("txtIkenshoIraiYoteibi")
    public TextBoxDate getTxtIkenshoIraiYoteibi() {
        return txtIkenshoIraiYoteibi;
    }

    @JsonProperty("txtIkenshoIraiYoteibi")
    public void setTxtIkenshoIraiYoteibi(TextBoxDate txtIkenshoIraiYoteibi) {
        this.txtIkenshoIraiYoteibi=txtIkenshoIraiYoteibi;
    }

}
/**
 * celIkenshoNyushuYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celIkenshoNyushuYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtIkenshoNyushuYoteibi")
    private TextBoxDate txtIkenshoNyushuYoteibi;

    @JsonProperty("txtIkenshoNyushuYoteibi")
    public TextBoxDate getTxtIkenshoNyushuYoteibi() {
        return txtIkenshoNyushuYoteibi;
    }

    @JsonProperty("txtIkenshoNyushuYoteibi")
    public void setTxtIkenshoNyushuYoteibi(TextBoxDate txtIkenshoNyushuYoteibi) {
        this.txtIkenshoNyushuYoteibi=txtIkenshoNyushuYoteibi;
    }

}
/**
 * celIchijiHanteiYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celIchijiHanteiYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtIchijiHanteiYoteibi")
    private TextBoxDate txtIchijiHanteiYoteibi;

    @JsonProperty("txtIchijiHanteiYoteibi")
    public TextBoxDate getTxtIchijiHanteiYoteibi() {
        return txtIchijiHanteiYoteibi;
    }

    @JsonProperty("txtIchijiHanteiYoteibi")
    public void setTxtIchijiHanteiYoteibi(TextBoxDate txtIchijiHanteiYoteibi) {
        this.txtIchijiHanteiYoteibi=txtIchijiHanteiYoteibi;
    }

}
/**
 * celShinsakaiTorokuYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celShinsakaiTorokuYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtShinsakaiTorokuYoteibi")
    private TextBoxDate txtShinsakaiTorokuYoteibi;

    @JsonProperty("txtShinsakaiTorokuYoteibi")
    public TextBoxDate getTxtShinsakaiTorokuYoteibi() {
        return txtShinsakaiTorokuYoteibi;
    }

    @JsonProperty("txtShinsakaiTorokuYoteibi")
    public void setTxtShinsakaiTorokuYoteibi(TextBoxDate txtShinsakaiTorokuYoteibi) {
        this.txtShinsakaiTorokuYoteibi=txtShinsakaiTorokuYoteibi;
    }

}
/**
 * celNijiHanteiYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celNijiHanteiYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtNijiHanteiYoteibi")
    private TextBoxDate txtNijiHanteiYoteibi;

    @JsonProperty("txtNijiHanteiYoteibi")
    public TextBoxDate getTxtNijiHanteiYoteibi() {
        return txtNijiHanteiYoteibi;
    }

    @JsonProperty("txtNijiHanteiYoteibi")
    public void setTxtNijiHanteiYoteibi(TextBoxDate txtNijiHanteiYoteibi) {
        this.txtNijiHanteiYoteibi=txtNijiHanteiYoteibi;
    }

}
/**
 * celHanteigoShoriYoteibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanteigoShoriYoteibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtHanteigoShoriYoteibi")
    private TextBoxDate txtHanteigoShoriYoteibi;

    @JsonProperty("txtHanteigoShoriYoteibi")
    public TextBoxDate getTxtHanteigoShoriYoteibi() {
        return txtHanteigoShoriYoteibi;
    }

    @JsonProperty("txtHanteigoShoriYoteibi")
    public void setTxtHanteigoShoriYoteibi(TextBoxDate txtHanteigoShoriYoteibi) {
        this.txtHanteigoShoriYoteibi=txtHanteigoShoriYoteibi;
    }

}
/**
 * celChosahyoNyushuJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celChosahyoNyushuJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtChosahyoNyushuJissekibi")
    private TextBoxDate txtChosahyoNyushuJissekibi;

    @JsonProperty("txtChosahyoNyushuJissekibi")
    public TextBoxDate getTxtChosahyoNyushuJissekibi() {
        return txtChosahyoNyushuJissekibi;
    }

    @JsonProperty("txtChosahyoNyushuJissekibi")
    public void setTxtChosahyoNyushuJissekibi(TextBoxDate txtChosahyoNyushuJissekibi) {
        this.txtChosahyoNyushuJissekibi=txtChosahyoNyushuJissekibi;
    }

}
/**
 * celIkenshoIraiJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celIkenshoIraiJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtIkenshoIraiJissekibi")
    private TextBoxDate txtIkenshoIraiJissekibi;

    @JsonProperty("txtIkenshoIraiJissekibi")
    public TextBoxDate getTxtIkenshoIraiJissekibi() {
        return txtIkenshoIraiJissekibi;
    }

    @JsonProperty("txtIkenshoIraiJissekibi")
    public void setTxtIkenshoIraiJissekibi(TextBoxDate txtIkenshoIraiJissekibi) {
        this.txtIkenshoIraiJissekibi=txtIkenshoIraiJissekibi;
    }

}
/**
 * celIkenshoNyushuJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celIkenshoNyushuJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtIkenshoNyushuJissekibi")
    private TextBoxDate txtIkenshoNyushuJissekibi;

    @JsonProperty("txtIkenshoNyushuJissekibi")
    public TextBoxDate getTxtIkenshoNyushuJissekibi() {
        return txtIkenshoNyushuJissekibi;
    }

    @JsonProperty("txtIkenshoNyushuJissekibi")
    public void setTxtIkenshoNyushuJissekibi(TextBoxDate txtIkenshoNyushuJissekibi) {
        this.txtIkenshoNyushuJissekibi=txtIkenshoNyushuJissekibi;
    }

}
/**
 * celIchijiHanteiJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celIchijiHanteiJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtIchijiHanteiJissekibi")
    private TextBoxDate txtIchijiHanteiJissekibi;

    @JsonProperty("txtIchijiHanteiJissekibi")
    public TextBoxDate getTxtIchijiHanteiJissekibi() {
        return txtIchijiHanteiJissekibi;
    }

    @JsonProperty("txtIchijiHanteiJissekibi")
    public void setTxtIchijiHanteiJissekibi(TextBoxDate txtIchijiHanteiJissekibi) {
        this.txtIchijiHanteiJissekibi=txtIchijiHanteiJissekibi;
    }

}
/**
 * celShinsakaiTorokuJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celShinsakaiTorokuJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtShinsakaiTorokuJissekibi")
    private TextBoxDate txtShinsakaiTorokuJissekibi;

    @JsonProperty("txtShinsakaiTorokuJissekibi")
    public TextBoxDate getTxtShinsakaiTorokuJissekibi() {
        return txtShinsakaiTorokuJissekibi;
    }

    @JsonProperty("txtShinsakaiTorokuJissekibi")
    public void setTxtShinsakaiTorokuJissekibi(TextBoxDate txtShinsakaiTorokuJissekibi) {
        this.txtShinsakaiTorokuJissekibi=txtShinsakaiTorokuJissekibi;
    }

}
/**
 * celNijiHanteiJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celNijiHanteiJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtNijiHanteiJissekibi")
    private TextBoxDate txtNijiHanteiJissekibi;

    @JsonProperty("txtNijiHanteiJissekibi")
    public TextBoxDate getTxtNijiHanteiJissekibi() {
        return txtNijiHanteiJissekibi;
    }

    @JsonProperty("txtNijiHanteiJissekibi")
    public void setTxtNijiHanteiJissekibi(TextBoxDate txtNijiHanteiJissekibi) {
        this.txtNijiHanteiJissekibi=txtNijiHanteiJissekibi;
    }

}
/**
 * celHanteigoShoriJissekibi のクラスファイル 
 * 
 * @author 自動生成
 */
class celHanteigoShoriJissekibiAttblShinchokuKakunin extends TableCell {
    @JsonProperty("txtHanteigoShoriJissekibi")
    private TextBoxDate txtHanteigoShoriJissekibi;

    @JsonProperty("txtHanteigoShoriJissekibi")
    public TextBoxDate getTxtHanteigoShoriJissekibi() {
        return txtHanteigoShoriJissekibi;
    }

    @JsonProperty("txtHanteigoShoriJissekibi")
    public void setTxtHanteigoShoriJissekibi(TextBoxDate txtHanteigoShoriJissekibi) {
        this.txtHanteigoShoriJissekibi=txtHanteigoShoriJissekibi;
    }

}
